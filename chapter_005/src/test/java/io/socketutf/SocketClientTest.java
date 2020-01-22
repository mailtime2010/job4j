package io.socketutf;

import com.google.common.base.Joiner;
import io.socketutf.connect.SocketClient;
import io.socketutf.input.Input;
import io.socketutf.input.StubInput;
import io.socketutf.input.ValidateInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SocketClientTest {
    public static final String LN = System.getProperty("line.separator");
    final Socket socket = mock(Socket.class);
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void setAfter() throws IOException {
        this.socket.close();
        System.setOut(System.out);
    }

    public final void setTestClient(final String request, final String result) throws IOException {
        final Input input = new ValidateInput(new StubInput(request.split(LN)));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeUTF(request);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bos.toByteArray());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        SocketClient client = new SocketClient(socket, input);
        client.startClient();
        final DataInputStream dis = new DataInputStream(new ByteArrayInputStream(out.toByteArray()));
        StringBuilder sb = new StringBuilder();
        while (dis.available() > 0) {
            sb.append(dis.readUTF());
        }
        assertThat(sb.toString(), is(result));
        dis.close();
        in.close();
        out.close();
    }

    @Test
    public void whenClientOutExit() throws IOException {
        final String query = "exit";
        final String result = Joiner.on(LN).join("exit", "");
        setTestClient(query, result);
    }


    @Test
    public void whenClientExit() throws IOException {
        final String query = Joiner.on(LN).join("Hello Oracle", "exit");
        final String result = Joiner.on(LN).join("Hello Oracle", "exit", "");
        setTestClient(query, result);

    }


    @Test
    public void whenClientHelloThenBackGreatOracle() throws IOException {
        final String query = Joiner.on(LN).join("to be or not to be?", "exit");
        final String result = Joiner.on(LN).join("to be or not to be?", "exit", "");
        setTestClient(query, result);
    }
}
