/* 
 * Copyright (c) 2009, 2012 IBM Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dave Locke - initial API and implementation and/or initial documentation
 */
package kr.msp.upns.client.mqttv3.internal.wire;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import kr.msp.upns.client.mqttv3.MqttException;


/**
 * An <code>MqttOutputStream</code> lets applications write instances of
 * <code>MqttWireMessage</code>. 
 */
public class MqttOutputStream extends OutputStream {
	private DataOutputStream out;
	
	public MqttOutputStream(OutputStream out) {
		this.out = new DataOutputStream(out);
	}
	
	public void close() throws IOException {
		out.close();
	}
	
	public void flush() throws IOException {
		out.flush();
	}
	
	public void write(byte[] b) throws IOException {
		out.write(b);
	}
	
	public void write(byte[] b, int off, int len) throws IOException {
		out.write(b, off, len);
	}
	
	public void write(int b) throws IOException {
		out.write(b);
	}

	/**
	 * Writes an <code>MqttWireMessage</code> to the stream.
	 */
	public void write(MqttWireMessage message) throws IOException, MqttException {
		byte[] bytes = message.getHeader();
		byte[] pl = message.getPayload();
		out.write(message.getHeader());
		out.write(message.getPayload());
	}
}

