/**
 * 
 */

/**
 * @author Ricky
 *
 */
public class WizIO_Config {
	/**
	 * 
	 */

	private final int length = 225;

	class __network_info_common {
		byte[] mac = new byte[6];
		byte[] local_ip = new byte[4];
		byte[] gateway = new byte[4];
		byte[] subnet = new byte[4];
		byte[] dns = new byte[4];
	}
	
	class __mqtt_info {
		byte[] user	= new byte[10];
		byte[] pw		= new byte[10];
		byte[] publish_topic	= new byte[25];
		byte[] subscribe_topic	= new byte[25];
	}

	class __working_info {
		byte[] remote_ip = new byte[4];

		short local_port;
		short remote_port;
		
		byte mode;
		byte state;	// 소켓의 상태 TCP의 경우 Not Connected, Connected, UDP의 경우 UDP
	}

	class __analog_in_common {
		byte filter;
		short modbus_address;
	}
	
	class __analog_in {
		byte use;
		short value;
	}
	
	class __digital_in {
		byte use;
		short value;
		
		byte mode;
		short modbus_address;
	}
	class __digital_out {
		byte use;
		short value;
		
		byte mode;
		short modbus_address;
		
		short high_width;
		short low_width;
	}
	class __options {
		byte[] module_name = new byte[20];
		byte[] pw_setting = new byte[10];

		byte dhcp_use;		
		byte dns_use;
		byte[] dns_domain_name = new byte[30];
		
		short reconnection;
		short transfer_interval;	
		
		byte[] separator = new byte[1];
		byte form;
	}
	short packet_size;
	byte[] module_type = new byte[3]; // 모듈의 종류별로 코드를 부여하고 이를 사용한다.
	byte[] fw_ver = new byte[3];			// 10진수. Major Version . Minor Version . Maintenance Version 버전으로 나뉨
	
	__network_info_common network_info_common = null;
	__mqtt_info mqtt_info;
	__working_info working_info;
	__analog_in_common analog_common;
	__analog_in[] analog_in = new __analog_in[4];
	__digital_in[] digital_in = new __digital_in[2];
	__digital_out[] digital_out = new __digital_out[2];
	__options options;
	
	public WizIO_Config() {
		int i;
		packet_size = length;

		module_type[0] = 0x04;
		module_type[1] = 0x00;
		module_type[2] = 0x00;

		network_info_common = new __network_info_common();
		
		mqtt_info = new __mqtt_info();
		working_info = new __working_info();
		analog_common = new __analog_in_common();

		for(i=0; i<analog_in.length; i++) {
			analog_in[i] = new __analog_in();
		}
		
		for(i=0; i<digital_in.length; i++) {
			digital_in[i] = new __digital_in();
		}
		
		for(i=0; i<digital_out.length; i++) {
			digital_out[i] = new __digital_out();
		}
		options = new __options();
	}

	public int getLength() {
		return length;
	}

	public void setData(byte[] data) {
		int index = 0, i;

		packet_size = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
		module_type[0] = data[index++];
		module_type[1] = data[index++];
		module_type[2] = data[index++];
		fw_ver[0] = data[index++];
		fw_ver[1] = data[index++];
		fw_ver[2] = data[index++];

		//network common
		for(i=0; i<6; i++)
			network_info_common.mac[i] = data[index++];
		for(i=0; i<4; i++)
			network_info_common.local_ip[i] = data[index++];
		for(i=0; i<4; i++)
			network_info_common.gateway[i] = data[index++];
		for(i=0; i<4; i++)
			network_info_common.subnet[i] = data[index++];
		for(i=0; i<4; i++)
			network_info_common.dns[i] = data[index++];
		//mqtt
		for(i=0; i<10; i++)
			mqtt_info.user[i] = data[index++];
		for(i=0; i<10; i++)
			mqtt_info.pw[i] = data[index++];
		for(i=0; i<25; i++)
			mqtt_info.publish_topic[i] = data[index++];
		for(i=0; i<25; i++)
			mqtt_info.subscribe_topic[i] = data[index++];
		//working
		for(i=0; i<4; i++)
			working_info.remote_ip[i] = data[index++];
		working_info.local_port = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
		working_info.remote_port = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
		working_info.mode = data[index++];
		working_info.state = data[index++];
		//analog common
		analog_common.filter = data[index++];
		analog_common.modbus_address = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
		//analog in
		for(i=0; i<4; i++) {
			analog_in[i].use = data[index++];
			analog_in[i].value = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
		}
		//digital in	
		for(i=0; i<2; i++) {
			digital_in[i].use = data[index++];
			digital_in[i].value = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
			digital_in[i].mode = data[index++];
			digital_in[i].modbus_address = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
		}
		//digital out
		for(i=0; i<2; i++) {
			digital_out[i].use = data[index++];
			digital_out[i].value = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
			digital_out[i].mode = data[index++];
			digital_out[i].modbus_address = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
			digital_out[i].high_width = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
			digital_out[i].low_width = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
		}
		//option
		for(i=0; i<20; i++)
			options.module_name[i] = data[index++];
		for(i=0; i<10; i++)
			options.pw_setting[i] = data[index++];
		options.dhcp_use = data[index++];
		options.dns_use = data[index++];
		for(i=0; i<30; i++)
			options.dns_domain_name[i] = data[index++];
		options.reconnection = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
		options.transfer_interval = (short) ((0xFF&data[index++]) + ((0xFF&data[index++]) << 8));
		options.separator[0] = data[index++];
		options.form = data[index++];
	}

	public byte[] getData() {
		byte[] data = new byte[length];
		int index = 0, i;

		data[index++] = (byte) packet_size;
		data[index++] = (byte) (packet_size >> 8);
		data[index++] = module_type[0];
		data[index++] = module_type[1];
		data[index++] = module_type[2];
		data[index++] = fw_ver[0];
		data[index++] = fw_ver[1];
		data[index++] = fw_ver[2];

		//network common
		for(i=0; i<6; i++)
			data[index++] = network_info_common.mac[i];
		for(i=0; i<4; i++)
			data[index++] = network_info_common.local_ip[i];
		for(i=0; i<4; i++)
			data[index++] = network_info_common.gateway[i];
		for(i=0; i<4; i++)
			data[index++] = network_info_common.subnet[i];
		for(i=0; i<4; i++)
			data[index++] = network_info_common.dns[i];
		//mqtt
		for(i=0; i<10; i++) {
			if(i >= mqtt_info.user.length)
				data[index++] = '\0';
			else
				data[index++] = mqtt_info.user[i];
		}
		for(i=0; i<10; i++) {
			if(i >= mqtt_info.pw.length)
				data[index++] = '\0';
			else
				data[index++] = mqtt_info.pw[i];
		}
		for(i=0; i<25; i++) {
			if(i >= mqtt_info.publish_topic.length)
				data[index++] = '\0';
			else
				data[index++] = mqtt_info.publish_topic[i];
		}
		for(i=0; i<25; i++) {
			if(i >= mqtt_info.subscribe_topic.length)
				data[index++] = '\0';
			else
				data[index++] = mqtt_info.subscribe_topic[i];
		}
		//working
		for(i=0; i<4; i++)
			data[index++] = working_info.remote_ip[i];
		data[index++] = (byte) working_info.local_port;
		data[index++] = (byte) (working_info.local_port >> 8);
		data[index++] = (byte) working_info.remote_port;
		data[index++] = (byte) (working_info.remote_port >> 8);
		data[index++] = working_info.mode;
		data[index++] = working_info.state;
		//analog common
		data[index++] = analog_common.filter;
		data[index++] = (byte) analog_common.modbus_address;
		data[index++] = (byte) (analog_common.modbus_address >> 8);
		//analog in
		for(i=0; i<4; i++) {
			data[index++] = analog_in[i].use;
			data[index++] = (byte) analog_in[i].value;
			data[index++] = (byte) (analog_in[i].value >> 8);
		}
		//digital in
		for(i=0; i<2; i++) {
			data[index++] = digital_in[i].use;
			data[index++] = (byte) digital_in[i].value;
			data[index++] = (byte) (digital_in[i].value >> 8);
			data[index++] = digital_in[i].mode;
			data[index++] = (byte) digital_in[i].modbus_address;
			data[index++] = (byte) (digital_in[i].modbus_address >> 8);
		}
		//digital out
		for(i=0; i<2; i++) {
			data[index++] = digital_out[i].use;
			data[index++] = (byte) digital_out[i].value;
			data[index++] = (byte) (digital_out[i].value >> 8);
			data[index++] = digital_out[i].mode;
			data[index++] = (byte) digital_out[i].modbus_address;
			data[index++] = (byte) (digital_out[i].modbus_address >> 8);
			data[index++] = (byte) digital_out[i].high_width;
			data[index++] = (byte) (digital_out[i].high_width >> 8);
			data[index++] = (byte) digital_out[i].low_width;
			data[index++] = (byte) (digital_out[i].low_width >> 8);
		}
		//option	
		for(i=0; i<20; i++) {
			if(i >= options.module_name.length)
				data[index++] = '\0';
			else
				data[index++] = options.module_name[i];
		}
		for(i=0; i<10; i++) {
			if(i >= options.pw_setting.length)
				data[index++] = '\0';
			else
				data[index++] = options.pw_setting[i];
		}
		data[index++] = options.dhcp_use;
		data[index++] = options.dns_use;
		for(i=0; i<30; i++) {
			if(i >= options.dns_domain_name.length)
				data[index++] = '\0';
			else
				data[index++] = options.dns_domain_name[i];
		}
		data[index++] = (byte) options.reconnection;
		data[index++] = (byte) (options.reconnection >> 8);
		data[index++] = (byte) options.transfer_interval;
		data[index++] = (byte) (options.transfer_interval >> 8);
		for(i=0; i<1; i++) {
			if(i >= options.separator.length)
				data[index++] = '\0';
			else
				data[index++] = options.separator[i];
		}
		data[index++] = options.form;
		
		return data;
	}
}
