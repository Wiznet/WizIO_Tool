import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class PanelManager {

	private final static int WizIO 	= 0x040000;

	public static void clearPanel(GUI gui) {
		//General page
		gui.txtIp.setText("");
		gui.txtGateway.setText("");
		gui.txtSubnet.setText("");
		gui.txtDnsServerIp.setText("");
		gui.txtLocalPort.setText("");
		
		gui.chckbxUseDhcp.setSelected(false);
		gui.chckbxUseDns.setSelected(false);
		gui.txtDomain.setText("");
		
		gui.txtHostIp.setText("");
		gui.txtRemotePort.setText("");
		
		gui.txtMqttUser.setText("");
		gui.txtMqttPassword.setText("");
		gui.txtMqttPublishTopic.setText("");
		gui.txtMqttSubscribeTopic.setText("");
		
		gui.rdbtnTcpClient.setSelected(false);
		gui.rdbtnTcpServer.setSelected(false);
		gui.rdbtnUdp.setSelected(false);
		gui.rdbtnMqtt.setSelected(false);
		gui.rdbtnModbusTcp.setSelected(false);
		gui.rdbtnModbusUdp.setSelected(false);
		
		gui.txtModuleName.setText("");
		gui.pwdSettingPassword.setText("");
		gui.txtReconnection.setText("");
		gui.txtDataTransfer.setText("");
		gui.txtAnalogSeperator.setText("");
		
		gui.cmbAnalogForm.setSelectedIndex(0);
		
		//Analog page
		gui.cmbAnalogFilter.setSelectedIndex(0);
		gui.txtAnalogModbusFuction.setText("");
		gui.txtAnalogModbusAddress.setText("");
		
		gui.chckbxEnableAnalogChannel_1.setSelected(false);
		gui.chckbxEnableAnalogChannel_2.setSelected(false);
		gui.chckbxEnableAnalogChannel_3.setSelected(false);
		gui.chckbxEnableAnalogChannel_4.setSelected(false);
		gui.chckbxEnableAnalogChannel_5.setSelected(false);
		gui.chckbxEnableAnalogChannel_6.setSelected(false);
		gui.chckbxEnableAnalogChannel_7.setSelected(false);
		gui.chckbxEnableAnalogChannel_8.setSelected(false);
		
		gui.txtAnalogChannelValue_1.setText("");
		gui.txtAnalogChannelValue_2.setText("");
		gui.txtAnalogChannelValue_3.setText("");
		gui.txtAnalogChannelValue_4.setText("");
		gui.txtAnalogChannelValue_5.setText("");
		gui.txtAnalogChannelValue_6.setText("");
		gui.txtAnalogChannelValue_7.setText("");
		gui.txtAnalogChannelValue_8.setText("");
		
		gui.txtAnalogInModbusAddressChannel_1.setText("");
		gui.txtAnalogInModbusAddressChannel_2.setText("");
		gui.txtAnalogInModbusAddressChannel_3.setText("");
		gui.txtAnalogInModbusAddressChannel_4.setText("");
		gui.txtAnalogInModbusAddressChannel_5.setText("");
		gui.txtAnalogInModbusAddressChannel_6.setText("");
		gui.txtAnalogInModbusAddressChannel_7.setText("");
		gui.txtAnalogInModbusAddressChannel_8.setText("");
		
		//Digital In page
		gui.chckbxEnableDigitalInChannel_1.setSelected(false);
		gui.chckbxEnableDigitalInChannel_2.setSelected(false);
		gui.chckbxEnableDigitalInChannel_3.setSelected(false);
		gui.chckbxEnableDigitalInChannel_4.setSelected(false);
		gui.chckbxEnableDigitalInChannel_5.setSelected(false);
		gui.chckbxEnableDigitalInChannel_6.setSelected(false);
		gui.chckbxEnableDigitalInChannel_7.setSelected(false);
		gui.chckbxEnableDigitalInChannel_8.setSelected(false);
		
		gui.txtDigitalInChannelValue_1.setText("");
		gui.txtDigitalInChannelValue_2.setText("");
		gui.txtDigitalInChannelValue_3.setText("");
		gui.txtDigitalInChannelValue_4.setText("");
		gui.txtDigitalInChannelValue_5.setText("");
		gui.txtDigitalInChannelValue_6.setText("");
		gui.txtDigitalInChannelValue_7.setText("");
		gui.txtDigitalInChannelValue_8.setText("");
		
		gui.cmbDigitalInModeChannel_1.setSelectedIndex(0);
		gui.cmbDigitalInModeChannel_2.setSelectedIndex(0);
		gui.cmbDigitalInModeChannel_3.setSelectedIndex(0);
		gui.cmbDigitalInModeChannel_4.setSelectedIndex(0);
		gui.cmbDigitalInModeChannel_5.setSelectedIndex(0);
		gui.cmbDigitalInModeChannel_6.setSelectedIndex(0);
		gui.cmbDigitalInModeChannel_7.setSelectedIndex(0);
		gui.cmbDigitalInModeChannel_8.setSelectedIndex(0);
		
		gui.txtDigitalInModbusFuctionChannel_1.setText("");
		gui.txtDigitalInModbusFuctionChannel_2.setText("");
		gui.txtDigitalInModbusFuctionChannel_3.setText("");
		gui.txtDigitalInModbusFuctionChannel_4.setText("");
		gui.txtDigitalInModbusFuctionChannel_5.setText("");
		gui.txtDigitalInModbusFuctionChannel_6.setText("");
		gui.txtDigitalInModbusFuctionChannel_7.setText("");
		gui.txtDigitalInModbusFuctionChannel_8.setText("");
		
		gui.txtDigitalInModbusAddressChannel_1.setText("");
		gui.txtDigitalInModbusAddressChannel_2.setText("");
		gui.txtDigitalInModbusAddressChannel_3.setText("");
		gui.txtDigitalInModbusAddressChannel_4.setText("");
		gui.txtDigitalInModbusAddressChannel_5.setText("");
		gui.txtDigitalInModbusAddressChannel_6.setText("");
		gui.txtDigitalInModbusAddressChannel_7.setText("");
		gui.txtDigitalInModbusAddressChannel_8.setText("");
		
		//Digital In page
		gui.chckbxEnableDigitalOutChannel_1.setSelected(false);
		gui.chckbxEnableDigitalOutChannel_2.setSelected(false);
		gui.chckbxEnableDigitalOutChannel_3.setSelected(false);
		gui.chckbxEnableDigitalOutChannel_4.setSelected(false);
		gui.chckbxEnableDigitalOutChannel_5.setSelected(false);
		gui.chckbxEnableDigitalOutChannel_6.setSelected(false);
		gui.chckbxEnableDigitalOutChannel_7.setSelected(false);
		gui.chckbxEnableDigitalOutChannel_8.setSelected(false);
		
		gui.txtDigitalOutChannelValue_1.setText("");
		gui.txtDigitalOutChannelValue_2.setText("");
		gui.txtDigitalOutChannelValue_3.setText("");
		gui.txtDigitalOutChannelValue_4.setText("");
		gui.txtDigitalOutChannelValue_5.setText("");
		gui.txtDigitalOutChannelValue_6.setText("");
		gui.txtDigitalOutChannelValue_7.setText("");
		gui.txtDigitalOutChannelValue_8.setText("");
		
		gui.cmbDigitalOutModeChannel_1.setSelectedIndex(0);
		gui.cmbDigitalOutModeChannel_2.setSelectedIndex(0);
		gui.cmbDigitalOutModeChannel_3.setSelectedIndex(0);
		gui.cmbDigitalOutModeChannel_4.setSelectedIndex(0);
		gui.cmbDigitalOutModeChannel_5.setSelectedIndex(0);
		gui.cmbDigitalOutModeChannel_6.setSelectedIndex(0);
		gui.cmbDigitalOutModeChannel_7.setSelectedIndex(0);
		gui.cmbDigitalOutModeChannel_8.setSelectedIndex(0);
		
		gui.txtDigitalOutModbusFuctionChannel_1.setText("");
		gui.txtDigitalOutModbusFuctionChannel_2.setText("");
		gui.txtDigitalOutModbusFuctionChannel_3.setText("");
		gui.txtDigitalOutModbusFuctionChannel_4.setText("");
		gui.txtDigitalOutModbusFuctionChannel_5.setText("");
		gui.txtDigitalOutModbusFuctionChannel_6.setText("");
		gui.txtDigitalOutModbusFuctionChannel_7.setText("");
		gui.txtDigitalOutModbusFuctionChannel_8.setText("");
		
		gui.txtDigitalOutModbusAddressChannel_1.setText("");
		gui.txtDigitalOutModbusAddressChannel_2.setText("");
		gui.txtDigitalOutModbusAddressChannel_3.setText("");
		gui.txtDigitalOutModbusAddressChannel_4.setText("");
		gui.txtDigitalOutModbusAddressChannel_5.setText("");
		gui.txtDigitalOutModbusAddressChannel_6.setText("");
		gui.txtDigitalOutModbusAddressChannel_7.setText("");
		gui.txtDigitalOutModbusAddressChannel_8.setText("");
		
		gui.txtDigitalOutHighWidthChannel_1.setText("");
		gui.txtDigitalOutHighWidthChannel_2.setText("");
		gui.txtDigitalOutHighWidthChannel_3.setText("");
		gui.txtDigitalOutHighWidthChannel_4.setText("");
		gui.txtDigitalOutHighWidthChannel_5.setText("");
		gui.txtDigitalOutHighWidthChannel_6.setText("");
		gui.txtDigitalOutHighWidthChannel_7.setText("");
		gui.txtDigitalOutHighWidthChannel_8.setText("");
		
		gui.txtDigitalOutLowWidthChannel_1.setText("");
		gui.txtDigitalOutLowWidthChannel_2.setText("");
		gui.txtDigitalOutLowWidthChannel_3.setText("");
		gui.txtDigitalOutLowWidthChannel_4.setText("");
		gui.txtDigitalOutLowWidthChannel_5.setText("");
		gui.txtDigitalOutLowWidthChannel_6.setText("");
		gui.txtDigitalOutLowWidthChannel_7.setText("");
		gui.txtDigitalOutLowWidthChannel_8.setText("");
		
		gui.txtDigitalOutFrequencyChannel_1.setText("");
		gui.txtDigitalOutFrequencyChannel_2.setText("");
		gui.txtDigitalOutFrequencyChannel_3.setText("");
		gui.txtDigitalOutFrequencyChannel_4.setText("");
		gui.txtDigitalOutFrequencyChannel_5.setText("");
		gui.txtDigitalOutFrequencyChannel_6.setText("");
		gui.txtDigitalOutFrequencyChannel_7.setText("");
		gui.txtDigitalOutFrequencyChannel_8.setText("");
		
		gui.txtDigitalOutDutyCycleChannel_1.setText("");
		gui.txtDigitalOutDutyCycleChannel_2.setText("");
		gui.txtDigitalOutDutyCycleChannel_3.setText("");
		gui.txtDigitalOutDutyCycleChannel_4.setText("");
		gui.txtDigitalOutDutyCycleChannel_5.setText("");
		gui.txtDigitalOutDutyCycleChannel_6.setText("");
		gui.txtDigitalOutDutyCycleChannel_7.setText("");
		gui.txtDigitalOutDutyCycleChannel_8.setText("");
		
		gui.txtFirmwareVersion.setText("");
		gui.txtNetworkStatus.setText("");
	}

	public static void setPanel(GUI gui, int moduleType) {
		switch(moduleType) {
		case WizIO:
			//Analog In page
			gui.chckbxEnableAnalogChannel_5.setEnabled(false);
			gui.chckbxEnableAnalogChannel_6.setEnabled(false);
			gui.chckbxEnableAnalogChannel_7.setEnabled(false);
			gui.chckbxEnableAnalogChannel_8.setEnabled(false);
			gui.txtAnalogChannelValue_5.setEnabled(false);
			gui.txtAnalogChannelValue_6.setEnabled(false);
			gui.txtAnalogChannelValue_7.setEnabled(false);
			gui.txtAnalogChannelValue_8.setEnabled(false);
			gui.txtAnalogInModbusAddressChannel_5.setEnabled(false);
			gui.txtAnalogInModbusAddressChannel_6.setEnabled(false);
			gui.txtAnalogInModbusAddressChannel_7.setEnabled(false);
			gui.txtAnalogInModbusAddressChannel_8.setEnabled(false);
			
			//Digital In page
			gui.chckbxEnableDigitalInChannel_3.setEnabled(false);
			gui.chckbxEnableDigitalInChannel_4.setEnabled(false);
			gui.chckbxEnableDigitalInChannel_5.setEnabled(false);
			gui.chckbxEnableDigitalInChannel_6.setEnabled(false);
			gui.chckbxEnableDigitalInChannel_7.setEnabled(false);
			gui.chckbxEnableDigitalInChannel_8.setEnabled(false);
			gui.txtDigitalInChannelValue_3.setEnabled(false);
			gui.txtDigitalInChannelValue_4.setEnabled(false);
			gui.txtDigitalInChannelValue_5.setEnabled(false);
			gui.txtDigitalInChannelValue_6.setEnabled(false);
			gui.txtDigitalInChannelValue_7.setEnabled(false);
			gui.txtDigitalInChannelValue_8.setEnabled(false);
			gui.cmbDigitalInModeChannel_3.setEnabled(false);
			gui.cmbDigitalInModeChannel_4.setEnabled(false);
			gui.cmbDigitalInModeChannel_5.setEnabled(false);
			gui.cmbDigitalInModeChannel_6.setEnabled(false);
			gui.cmbDigitalInModeChannel_7.setEnabled(false);
			gui.cmbDigitalInModeChannel_8.setEnabled(false);
			gui.txtDigitalInModbusFuctionChannel_3.setEnabled(false);
			gui.txtDigitalInModbusFuctionChannel_4.setEnabled(false);
			gui.txtDigitalInModbusFuctionChannel_5.setEnabled(false);
			gui.txtDigitalInModbusFuctionChannel_6.setEnabled(false);
			gui.txtDigitalInModbusFuctionChannel_7.setEnabled(false);
			gui.txtDigitalInModbusFuctionChannel_8.setEnabled(false);
			gui.txtDigitalInModbusAddressChannel_3.setEnabled(false);
			gui.txtDigitalInModbusAddressChannel_4.setEnabled(false);
			gui.txtDigitalInModbusAddressChannel_5.setEnabled(false);
			gui.txtDigitalInModbusAddressChannel_6.setEnabled(false);
			gui.txtDigitalInModbusAddressChannel_7.setEnabled(false);
			gui.txtDigitalInModbusAddressChannel_8.setEnabled(false);
			//Digital Out page
			gui.chckbxEnableDigitalOutChannel_3.setEnabled(false);
			gui.chckbxEnableDigitalOutChannel_4.setEnabled(false);
			gui.chckbxEnableDigitalOutChannel_5.setEnabled(false);
			gui.chckbxEnableDigitalOutChannel_6.setEnabled(false);
			gui.chckbxEnableDigitalOutChannel_7.setEnabled(false);
			gui.chckbxEnableDigitalOutChannel_8.setEnabled(false);
			gui.txtDigitalOutChannelValue_3.setEnabled(false);
			gui.txtDigitalOutChannelValue_4.setEnabled(false);
			gui.txtDigitalOutChannelValue_5.setEnabled(false);
			gui.txtDigitalOutChannelValue_6.setEnabled(false);
			gui.txtDigitalOutChannelValue_7.setEnabled(false);
			gui.txtDigitalOutChannelValue_8.setEnabled(false);
			gui.cmbDigitalOutModeChannel_3.setEnabled(false);
			gui.cmbDigitalOutModeChannel_4.setEnabled(false);
			gui.cmbDigitalOutModeChannel_5.setEnabled(false);
			gui.cmbDigitalOutModeChannel_6.setEnabled(false);
			gui.cmbDigitalOutModeChannel_7.setEnabled(false);
			gui.cmbDigitalOutModeChannel_8.setEnabled(false);
			gui.txtDigitalOutModbusFuctionChannel_3.setEnabled(false);
			gui.txtDigitalOutModbusFuctionChannel_4.setEnabled(false);
			gui.txtDigitalOutModbusFuctionChannel_5.setEnabled(false);
			gui.txtDigitalOutModbusFuctionChannel_6.setEnabled(false);
			gui.txtDigitalOutModbusFuctionChannel_7.setEnabled(false);
			gui.txtDigitalOutModbusFuctionChannel_8.setEnabled(false);
			gui.txtDigitalOutModbusAddressChannel_3.setEnabled(false);
			gui.txtDigitalOutModbusAddressChannel_4.setEnabled(false);
			gui.txtDigitalOutModbusAddressChannel_5.setEnabled(false);
			gui.txtDigitalOutModbusAddressChannel_6.setEnabled(false);
			gui.txtDigitalOutModbusAddressChannel_7.setEnabled(false);
			gui.txtDigitalOutModbusAddressChannel_8.setEnabled(false);
			gui.txtDigitalOutHighWidthChannel_3.setEnabled(false);
			gui.txtDigitalOutHighWidthChannel_4.setEnabled(false);
			gui.txtDigitalOutHighWidthChannel_5.setEnabled(false);
			gui.txtDigitalOutHighWidthChannel_6.setEnabled(false);
			gui.txtDigitalOutHighWidthChannel_7.setEnabled(false);
			gui.txtDigitalOutHighWidthChannel_8.setEnabled(false);
			gui.txtDigitalOutLowWidthChannel_3.setEnabled(false);
			gui.txtDigitalOutLowWidthChannel_4.setEnabled(false);
			gui.txtDigitalOutLowWidthChannel_5.setEnabled(false);
			gui.txtDigitalOutLowWidthChannel_6.setEnabled(false);
			gui.txtDigitalOutLowWidthChannel_7.setEnabled(false);
			gui.txtDigitalOutLowWidthChannel_8.setEnabled(false);
			gui.txtDigitalOutFrequencyChannel_3.setEnabled(false);
			gui.txtDigitalOutFrequencyChannel_4.setEnabled(false);
			gui.txtDigitalOutFrequencyChannel_5.setEnabled(false);
			gui.txtDigitalOutFrequencyChannel_6.setEnabled(false);
			gui.txtDigitalOutFrequencyChannel_7.setEnabled(false);
			gui.txtDigitalOutFrequencyChannel_8.setEnabled(false);
			gui.txtDigitalOutDutyCycleChannel_3.setEnabled(false);
			gui.txtDigitalOutDutyCycleChannel_4.setEnabled(false);
			gui.txtDigitalOutDutyCycleChannel_5.setEnabled(false);
			gui.txtDigitalOutDutyCycleChannel_6.setEnabled(false);
			gui.txtDigitalOutDutyCycleChannel_7.setEnabled(false);
			gui.txtDigitalOutDutyCycleChannel_8.setEnabled(false);
			
			break;
		default:
			break;
		}
	}
	
	/* WizIO--> */
	public static void updateToPanel(GUI gui, WizIO_Config packet) {
		clearPanel(gui);
		setPanel(gui, WizIO);

		String str;
		double DutyCycle, Frequency;
		double ValueTemp;
		
		if((0xFF&packet.fw_ver[0]) > 100) {
			str = String.format("Bootloader %d.%d.%d", (0xFF&packet.fw_ver[0]) - 100, (0xFF&packet.fw_ver[1]), (0xFF&packet.fw_ver[2]));
		}
		else {
			str = String.format("%d.%d.%d", (0xFF&packet.fw_ver[0]), (0xFF&packet.fw_ver[1]), (0xFF&packet.fw_ver[2]));
		}
		gui.txtFirmwareVersion.setText(str);
	

		switch((0xFF&packet.working_info.state)) {
		case 0:
			str = "Disconnected";
			break;
		case 1:
			str = "Connected";
			break;
		case 2:
			str = "UDP";
			break;
		default:
			str = "";
			break;
		}
		gui.txtNetworkStatus.setText(str);

		//Network Setting
		str = String.format("%d.%d.%d.%d", (0xFF&packet.network_info_common.local_ip[0]), (0xFF&packet.network_info_common.local_ip[1]), (0xFF&packet.network_info_common.local_ip[2]), (0xFF&packet.network_info_common.local_ip[3]));
		gui.txtIp.setText(str);
		str = String.format("%d.%d.%d.%d", (0xFF&packet.network_info_common.gateway[0]), (0xFF&packet.network_info_common.gateway[1]), (0xFF&packet.network_info_common.gateway[2]), (0xFF&packet.network_info_common.gateway[3]));
		gui.txtGateway.setText(str);
		str = String.format("%d.%d.%d.%d", (0xFF&packet.network_info_common.subnet[0]), (0xFF&packet.network_info_common.subnet[1]), (0xFF&packet.network_info_common.subnet[2]), (0xFF&packet.network_info_common.subnet[3]));
		gui.txtSubnet.setText(str);
		str = String.format("%d.%d.%d.%d", (0xFF&packet.working_info.remote_ip[0]), (0xFF&packet.working_info.remote_ip[1]), (0xFF&packet.working_info.remote_ip[2]), (0xFF&packet.working_info.remote_ip[3]));
		gui.txtHostIp.setText(str);

		switch((0xFF&packet.options.dhcp_use)) {
		case 0:
			gui.chckbxUseDhcp.setSelected(false);
			break;
		case 1:
			gui.chckbxUseDhcp.setSelected(true);
			break;
		default:
			gui.chckbxUseDhcp.setSelected(false);
			break;
		}
		switch((0xFF&packet.options.dns_use)) {
		case 0:
			gui.chckbxUseDns.setSelected(false);
			break;
		case 1:
			gui.chckbxUseDns.setSelected(true);
			break;
		default:
			gui.chckbxUseDns.setSelected(false);
			break;
		}
		str = String.format("%d.%d.%d.%d", (0xFF&packet.network_info_common.dns[0]), (0xFF&packet.network_info_common.dns[1]), (0xFF&packet.network_info_common.dns[2]), (0xFF&packet.network_info_common.dns[3]));
		gui.txtDnsServerIp.setText(str);
		str = new String(packet.options.dns_domain_name);
		gui.txtDomain.setText(str.trim());
		
		str = String.format("%d", (0xFFFF&packet.working_info.local_port));
		gui.txtLocalPort.setText(str);
		str = String.format("%d", (0xFFFF&packet.working_info.remote_port));
		gui.txtRemotePort.setText(str);
		switch((0xFF&packet.working_info.mode)) {
		case 0:
			gui.rdbtnTcpClient.setSelected(true);
			break;
		case 1:
			gui.rdbtnTcpServer.setSelected(true);
			break;
		case 2:
			gui.rdbtnUdp.setSelected(true);
			break;
		case 3:
			gui.rdbtnMqtt.setSelected(true);
			break;
		case 4:
			gui.rdbtnModbusTcp.setSelected(true);
			break;
		case 5:
			gui.rdbtnModbusUdp.setSelected(true);
			break;
		default:
			break;
		}
		str = new String(packet.mqtt_info.user);
		gui.txtMqttUser.setText(str.trim());
		str = new String(packet.mqtt_info.pw);
		gui.txtMqttPassword.setText(str.trim());
		str = new String(packet.mqtt_info.publish_topic);
		gui.txtMqttPublishTopic.setText(str.trim());
		str = new String(packet.mqtt_info.subscribe_topic);
		gui.txtMqttSubscribeTopic.setText(str.trim());	
		
		//Analog In Setting
		gui.cmbAnalogFilter.setSelectedIndex((0xFF&packet.analog_common.filter));
	
		str = new String("Read Reg");
		gui.txtAnalogModbusFuction.setText(str.trim());
	
		str = String.format("%d", (0xFFFF&packet.analog_common.modbus_address));
		gui.txtAnalogModbusAddress.setText(str);
		
		str = String.format("%d", (0xFFFF&packet.analog_common.modbus_address));
		gui.txtAnalogInModbusAddressChannel_1.setText(str);
		str = String.format("%d", (0xFFFF&packet.analog_common.modbus_address+1));
		gui.txtAnalogInModbusAddressChannel_2.setText(str);
		str = String.format("%d", (0xFFFF&packet.analog_common.modbus_address+2));
		gui.txtAnalogInModbusAddressChannel_3.setText(str);
		str = String.format("%d", (0xFFFF&packet.analog_common.modbus_address+3));
		gui.txtAnalogInModbusAddressChannel_4.setText(str);
		
		//channel 1
		if(packet.analog_in[0].use == 1)
			gui.chckbxEnableAnalogChannel_1.setSelected(true);
		else
			gui.chckbxEnableAnalogChannel_1.setSelected(false);
		
		try {
			ValueTemp = (double)(0xFFFF&packet.analog_in[0].value) * (3.3/4096.0);
		} catch (ArithmeticException e) {
			ValueTemp = 0.0;
		}
		str = String.format("%.2f", ValueTemp);
		gui.txtAnalogChannelVoltage_1.setText(str);
		
		str = String.format("%d", (0xFFFF&packet.analog_in[0].value));
		gui.txtAnalogChannelValue_1.setText(str);
		//channel 2
		if(packet.analog_in[1].use == 1)
			gui.chckbxEnableAnalogChannel_2.setSelected(true);
		else
			gui.chckbxEnableAnalogChannel_2.setSelected(false);
		
		try {
			ValueTemp = (double)(0xFFFF&packet.analog_in[1].value) * (3.3/4096.0);
		} catch (ArithmeticException e) {
			ValueTemp = 0.0;
		}
		str = String.format("%.2f", ValueTemp);
		gui.txtAnalogChannelVoltage_2.setText(str);
		
		str = String.format("%d", (0xFFFF&packet.analog_in[1].value));
		gui.txtAnalogChannelValue_2.setText(str);
		//channel 3
		if(packet.analog_in[2].use == 1)
			gui.chckbxEnableAnalogChannel_3.setSelected(true);
		else
			gui.chckbxEnableAnalogChannel_3.setSelected(false);
		
		try {
			ValueTemp = (double)(0xFFFF&packet.analog_in[2].value) * (3.3/4096.0);
		} catch (ArithmeticException e) {
			ValueTemp = 0.0;
		}
		str = String.format("%.2f", ValueTemp);
		gui.txtAnalogChannelVoltage_3.setText(str);
		
		str = String.format("%d", (0xFFFF&packet.analog_in[2].value));
		gui.txtAnalogChannelValue_3.setText(str);
		//channel 4
		if(packet.analog_in[3].use == 1)
			gui.chckbxEnableAnalogChannel_4.setSelected(true);
		else
			gui.chckbxEnableAnalogChannel_4.setSelected(false);
		
		try {
			ValueTemp = (double)(0xFFFF&packet.analog_in[3].value) * (3.3/4096.0);
		} catch (ArithmeticException e) {
			ValueTemp = 0.0;
		}
		str = String.format("%.2f", ValueTemp);
		gui.txtAnalogChannelVoltage_4.setText(str);
		
		str = String.format("%d", (0xFFFF&packet.analog_in[3].value));
		gui.txtAnalogChannelValue_4.setText(str);
		
		//Digital In Setting
		//channel 1
		if(packet.digital_in[0].use == 1)
			gui.chckbxEnableDigitalInChannel_1.setSelected(true);
		else
			gui.chckbxEnableDigitalInChannel_1.setSelected(false);
		gui.cmbDigitalInModeChannel_1.setSelectedIndex((0xFF&packet.digital_in[0].mode));
		switch((0xFF&packet.digital_in[0].mode)) {
			case 0://DI
				if (packet.digital_in[0].value == 1) {
					str = new String("High");
					gui.txtDigitalInChannelValue_1.setText(str);
				} else {
					str = new String("Low");
					gui.txtDigitalInChannelValue_1.setText(str);
				}
				str = new String("Read Coil");
				gui.txtDigitalInModbusFuctionChannel_1.setText(str.trim());
				break;
			case 1://DI High Counter
				str = String.format("%d", (0xFFFF&packet.digital_in[0].value));
				gui.txtDigitalInChannelValue_1.setText(str+"(Count)");
				str = new String("Read Reg");
				gui.txtDigitalInModbusFuctionChannel_1.setText(str.trim());
				break;
			case 2://DI Low Counter
				str = String.format("%d", (0xFFFF&packet.digital_in[0].value));
				gui.txtDigitalInChannelValue_1.setText(str+"(Count)");
				str = new String("Read Reg");
				gui.txtDigitalInModbusFuctionChannel_1.setText(str.trim());
				break;
			case 3://DI Frequency
				str = String.format("%d", (0xFFFF&packet.digital_in[0].value));
				gui.txtDigitalInChannelValue_1.setText(str+"(100us)");
				str = new String("Read Reg");
				gui.txtDigitalInModbusFuctionChannel_1.setText(str.trim());
				break;
			default:
				str = new String("None");
				gui.txtDigitalInModbusFuctionChannel_1.setText(str.trim());
				break;
		}
		str = String.format("%d", (0xFFFF&packet.digital_in[0].modbus_address));
		gui.txtDigitalInModbusAddressChannel_1.setText(str);
		//channel 2
		if(packet.digital_in[1].use == 1)
			gui.chckbxEnableDigitalInChannel_2.setSelected(true);
		else
			gui.chckbxEnableDigitalInChannel_2.setSelected(false);
		gui.cmbDigitalInModeChannel_2.setSelectedIndex((0xFF&packet.digital_in[1].mode));
		switch((0xFF&packet.digital_in[1].mode)) {
			case 0://DI
				if (packet.digital_in[1].value == 1) {
					str = new String("High");
					gui.txtDigitalInChannelValue_2.setText(str);
				} else {
					str = new String("Low");
					gui.txtDigitalInChannelValue_2.setText(str);
				}
				str = new String("Read Coil");
				gui.txtDigitalInModbusFuctionChannel_2.setText(str.trim());
				break;
			case 1://DI High Counter
				str = String.format("%d", (0xFFFF&packet.digital_in[1].value));
				gui.txtDigitalInChannelValue_2.setText(str+"(Count)");
				str = new String("Read Reg");
				gui.txtDigitalInModbusFuctionChannel_2.setText(str.trim());
				break;
			case 2://DI Low Counter
				str = String.format("%d", (0xFFFF&packet.digital_in[1].value));
				gui.txtDigitalInChannelValue_2.setText(str+"(Count)");
				str = new String("Read Reg");
				gui.txtDigitalInModbusFuctionChannel_2.setText(str.trim());
				break;
			case 3://DI Frequency
				str = String.format("%d", (0xFFFF&packet.digital_in[1].value));
				gui.txtDigitalInChannelValue_2.setText(str+"(100us)");
				str = new String("Read Reg");
				gui.txtDigitalInModbusFuctionChannel_2.setText(str.trim());
				break;
			default:
				str = new String("None");
				gui.txtDigitalInModbusFuctionChannel_2.setText(str.trim());
				break;
		}
		str = String.format("%d", (0xFFFF&packet.digital_in[1].modbus_address));
		gui.txtDigitalInModbusAddressChannel_2.setText(str);
		
		
		//Digital Out Setting
		//channel 1
		if(packet.digital_out[0].use == 1)
			gui.chckbxEnableDigitalOutChannel_1.setSelected(true);
		else
			gui.chckbxEnableDigitalOutChannel_1.setSelected(false);
		gui.cmbDigitalOutModeChannel_1.setSelectedIndex((0xFF&packet.digital_out[0].mode));
		switch((0xFF&packet.digital_out[0].mode)) {
			case 0://DO
				if (packet.digital_out[0].value == 1) {
					str = new String("High");
					gui.txtDigitalOutChannelValue_1.setText(str);
				} else {
					str = new String("Low");
					gui.txtDigitalOutChannelValue_1.setText(str);
				}
				str = new String("Write Coil");
				gui.txtDigitalOutModbusFuctionChannel_1.setText(str.trim());
				break;
			case 1://DO Pulse
				str = String.format("%d", (0xFFFF&packet.digital_out[0].value));
				gui.txtDigitalOutChannelValue_1.setText(str+"(100us)");
				str = new String("Write Reg");
				gui.txtDigitalOutModbusFuctionChannel_1.setText(str.trim());
				break;
			default:
				str = new String("None");
				gui.txtDigitalOutModbusFuctionChannel_1.setText(str.trim());
				break;
		}
		str = String.format("%d", (0xFFFF&packet.digital_out[0].modbus_address));
		gui.txtDigitalOutModbusAddressChannel_1.setText(str);
		str = String.format("%d", (0xFFFF&packet.digital_out[0].modbus_address+1));
		gui.txtDigitalOutModbusAddress2Channel_1.setText(str);
		str = String.format("%d", (0xFFFF&packet.digital_out[0].high_width));
		gui.txtDigitalOutHighWidthChannel_1.setText(str);
		str = String.format("%d", (0xFFFF&packet.digital_out[0].low_width));
		gui.txtDigitalOutLowWidthChannel_1.setText(str);
		
		try {
			Frequency = 1.0/(((double)packet.digital_out[0].high_width+(double)packet.digital_out[0].low_width)/(double)10000.0);
		} catch (ArithmeticException e) {
			Frequency = 0.0;
		}
		str = String.format("%.2f", Frequency);
		gui.txtDigitalOutFrequencyChannel_1.setText(str);
		
		try {
			DutyCycle = (double)packet.digital_out[0].high_width/((double)packet.digital_out[0].high_width+(double)packet.digital_out[0].low_width);
		} catch (ArithmeticException e) {
			DutyCycle = 0.0;
		}
		
		str = String.format("%.2f", DutyCycle * (double)100.0);
		gui.txtDigitalOutDutyCycleChannel_1.setText(str);
		//channel 2
		if(packet.digital_out[1].use == 1)
			gui.chckbxEnableDigitalOutChannel_2.setSelected(true);
		else
			gui.chckbxEnableDigitalOutChannel_2.setSelected(false);
		gui.cmbDigitalOutModeChannel_2.setSelectedIndex((0xFF&packet.digital_out[1].mode));
		switch((0xFF&packet.digital_out[1].mode)) {
			case 0://DO
				if (packet.digital_out[1].value == 1) {
					str = new String("High");
					gui.txtDigitalOutChannelValue_2.setText(str);
				} else {
					str = new String("Low");
					gui.txtDigitalOutChannelValue_2.setText(str);
				}
				str = new String("Write Coil");
				gui.txtDigitalOutModbusFuctionChannel_2.setText(str.trim());
				break;
			case 1://DO Pulse
				str = String.format("%d", (0xFFFF&packet.digital_out[1].value));
				gui.txtDigitalOutChannelValue_2.setText(str+"(100us)");
				str = new String("Write Reg");
				gui.txtDigitalOutModbusFuctionChannel_2.setText(str.trim());
				break;
			default:
				str = new String("None");
				gui.txtDigitalOutModbusFuctionChannel_2.setText(str.trim());
				break;
		}
		str = String.format("%d", (0xFFFF&packet.digital_out[1].modbus_address));
		gui.txtDigitalOutModbusAddressChannel_2.setText(str);
		str = String.format("%d", (0xFFFF&packet.digital_out[1].modbus_address+1));
		gui.txtDigitalOutModbusAddress2Channel_2.setText(str);
		str = String.format("%d", (0xFFFF&packet.digital_out[1].high_width));
		gui.txtDigitalOutHighWidthChannel_2.setText(str);
		str = String.format("%d", (0xFFFF&packet.digital_out[1].low_width));
		gui.txtDigitalOutLowWidthChannel_2.setText(str);
		
		try {
			Frequency = 1.0/(((double)packet.digital_out[1].high_width+(double)packet.digital_out[1].low_width)/(double)10000.0);
		} catch (ArithmeticException e) {
			Frequency = 0.0;
		}
		str = String.format("%.2f", Frequency);
		gui.txtDigitalOutFrequencyChannel_2.setText(str);
		
		try {
			DutyCycle = (double)packet.digital_out[1].high_width/((double)packet.digital_out[1].high_width+(double)packet.digital_out[1].low_width);
		} catch (ArithmeticException e) {
			DutyCycle = 0.0;
		}
		
		str = String.format("%.2f", DutyCycle * (double)100.0);
		gui.txtDigitalOutDutyCycleChannel_2.setText(str);
		
		//Options Setting
		str = new String(packet.options.module_name);
		gui.txtModuleName.setText(str.trim());
		str = new String(packet.options.pw_setting);
		gui.pwdSettingPassword.setText(str.trim());

		str = String.format("%d", (0xFFFF&packet.options.reconnection));
		gui.txtReconnection.setText(str);
		str = String.format("%d", (0xFFFF&packet.options.transfer_interval));
		gui.txtDataTransfer.setText(str);
		str = new String(packet.options.separator);
		gui.txtAnalogSeperator.setText(str.trim());
		gui.cmbAnalogForm.setSelectedIndex((0xFF&packet.options.form));
	}

	public static boolean updateFromPanel(GUI gui, String selectedMac, WizIO_Config packet) {
		InputValidation valid = new InputValidation();
		String[] str_array;
		
		short[] digital_out_address_temp = new short[2];
		short[] digital_in_address_temp = new short[2];
		
		digital_out_address_temp[0] = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalOutModbusAddressChannel_1.getText(), 10));
		digital_out_address_temp[1] = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalOutModbusAddressChannel_2.getText(), 10));
		digital_in_address_temp[0] = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalInModbusAddressChannel_1.getText(), 10));
		digital_in_address_temp[1] = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalInModbusAddressChannel_2.getText(), 10));
		
		if(selectedMac == null)
			return false;
		if(packet == null)
			packet = new WizIO_Config();

		//Network Common
		str_array = selectedMac.split("\\:");
		packet.network_info_common.mac[0] = (byte) (0x00FF&Short.parseShort(str_array[0], 16));
		packet.network_info_common.mac[1] = (byte) (0x00FF&Short.parseShort(str_array[1], 16));
		packet.network_info_common.mac[2] = (byte) (0x00FF&Short.parseShort(str_array[2], 16));
		packet.network_info_common.mac[3] = (byte) (0x00FF&Short.parseShort(str_array[3], 16));
		packet.network_info_common.mac[4] = (byte) (0x00FF&Short.parseShort(str_array[4], 16));
		packet.network_info_common.mac[5] = (byte) (0x00FF&Short.parseShort(str_array[5], 16));
		
		if(!valid.IpValid(gui.txtIp.getText().trim())) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "IP input error");
			return false;
		}
		str_array = gui.txtIp.getText().split("\\.");
		packet.network_info_common.local_ip[0] = (byte) (0x00FF&Short.parseShort(str_array[0], 10));
		packet.network_info_common.local_ip[1] = (byte) (0x00FF&Short.parseShort(str_array[1], 10));
		packet.network_info_common.local_ip[2] = (byte) (0x00FF&Short.parseShort(str_array[2], 10));
		packet.network_info_common.local_ip[3] = (byte) (0x00FF&Short.parseShort(str_array[3], 10));

		if(!valid.IpValid(gui.txtGateway.getText().trim())) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Gateway input error");
			return false;
		}
		str_array = gui.txtGateway.getText().split("\\.");
		packet.network_info_common.gateway[0] = (byte) (0x00FF&Short.parseShort(str_array[0], 10));
		packet.network_info_common.gateway[1] = (byte) (0x00FF&Short.parseShort(str_array[1], 10));
		packet.network_info_common.gateway[2] = (byte) (0x00FF&Short.parseShort(str_array[2], 10));
		packet.network_info_common.gateway[3] = (byte) (0x00FF&Short.parseShort(str_array[3], 10));

		if(!valid.IpValid(gui.txtSubnet.getText().trim())) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Subnet input error");
			return false;
		}
		str_array = gui.txtSubnet.getText().split("\\.");
		packet.network_info_common.subnet[0] = (byte) (0x00FF&Short.parseShort(str_array[0], 10));
		packet.network_info_common.subnet[1] = (byte) (0x00FF&Short.parseShort(str_array[1], 10));
		packet.network_info_common.subnet[2] = (byte) (0x00FF&Short.parseShort(str_array[2], 10));
		packet.network_info_common.subnet[3] = (byte) (0x00FF&Short.parseShort(str_array[3], 10));

		//Network 
		if(!valid.IpValid(gui.txtHostIp.getText().trim())) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Host IP input error");
			return false;
		}
		str_array = gui.txtHostIp.getText().split("\\.");
		packet.working_info.remote_ip[0] = (byte) (0x00FF&Short.parseShort(str_array[0], 10));
		packet.working_info.remote_ip[1] = (byte) (0x00FF&Short.parseShort(str_array[1], 10));
		packet.working_info.remote_ip[2] = (byte) (0x00FF&Short.parseShort(str_array[2], 10));
		packet.working_info.remote_ip[3] = (byte) (0x00FF&Short.parseShort(str_array[3], 10));

		if(gui.chckbxUseDhcp.isSelected()) {
			packet.options.dhcp_use = 1;
		}
		else {
			packet.options.dhcp_use = 0;
		}
		if(gui.chckbxUseDns.isSelected()) {
			packet.options.dns_use = 1;
		}
		else {
			packet.options.dns_use = 0;
		}
		if(!valid.IpValid(gui.txtDnsServerIp.getText().trim())) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "DNS Server IP input error");
			return false;
		}
		str_array = gui.txtDnsServerIp.getText().split("\\.");
		packet.network_info_common.dns[0] = (byte) (0x00FF&Short.parseShort(str_array[0], 10));
		packet.network_info_common.dns[1] = (byte) (0x00FF&Short.parseShort(str_array[1], 10));
		packet.network_info_common.dns[2] = (byte) (0x00FF&Short.parseShort(str_array[2], 10));
		packet.network_info_common.dns[3] = (byte) (0x00FF&Short.parseShort(str_array[3], 10));
		packet.options.dns_domain_name = gui.txtDomain.getText().trim().getBytes();
		
		if(!valid.PortValid(gui.txtLocalPort.getText().trim())) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Local Port input error");
			return false;
		}
		packet.working_info.local_port = (short) (0x0000FFFF&Integer.parseInt(gui.txtLocalPort.getText(), 10));
		if(!valid.PortValid(gui.txtRemotePort.getText().trim())) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Remote Port input error");
			return false;
		}
		packet.working_info.remote_port = (short) (0x0000FFFF&Integer.parseInt(gui.txtRemotePort.getText(), 10));
		
		if(gui.rdbtnTcpClient.isSelected()) {
			packet.working_info.mode = 0;
		}
		else if(gui.rdbtnTcpServer.isSelected()) {
			packet.working_info.mode = 1;
		}
		else if(gui.rdbtnUdp.isSelected()) {
			packet.working_info.mode = 2;
		}
		else if(gui.rdbtnMqtt.isSelected()) {
			packet.working_info.mode = 3;
		}
		else if(gui.rdbtnModbusTcp.isSelected()) {
			packet.working_info.mode = 4;
		}
		else if(gui.rdbtnModbusUdp.isSelected()) {
			packet.working_info.mode = 5;
		}
		else {
			packet.working_info.mode = 0;
		}
		packet.mqtt_info.user = gui.txtMqttUser.getText().trim().getBytes();
		packet.mqtt_info.pw = gui.txtMqttPassword.getText().trim().getBytes();
		packet.mqtt_info.publish_topic = gui.txtMqttPublishTopic.getText().trim().getBytes();
		packet.mqtt_info.subscribe_topic = gui.txtMqttSubscribeTopic.getText().trim().getBytes();

		//Analog Common
		packet.analog_common.filter = (byte) (0x00FF&gui.cmbAnalogFilter.getSelectedIndex());
		packet.analog_common.modbus_address = (short) (0x0000FFFF&Integer.parseInt(gui.txtAnalogModbusAddress.getText(), 10));
		
		//Analog In
		if(gui.chckbxEnableAnalogChannel_1.isSelected()) {
			packet.analog_in[0].use = 1;
		}
		else {
			packet.analog_in[0].use = 0;
		}
		packet.analog_in[0].value = (short) (0x0000FFFF&Integer.parseInt(gui.txtAnalogChannelValue_1.getText(), 10));
		
		if(gui.chckbxEnableAnalogChannel_2.isSelected()) {
			packet.analog_in[1].use = 1;
		}
		else {
			packet.analog_in[1].use = 0;
		}
		packet.analog_in[1].value = (short) (0x0000FFFF&Integer.parseInt(gui.txtAnalogChannelValue_2.getText(), 10));
		
		if(gui.chckbxEnableAnalogChannel_3.isSelected()) {
			packet.analog_in[2].use = 1;
		}
		else {
			packet.analog_in[2].use = 0;
		}
		packet.analog_in[2].value = (short) (0x0000FFFF&Integer.parseInt(gui.txtAnalogChannelValue_3.getText(), 10));
		
		if(gui.chckbxEnableAnalogChannel_4.isSelected()) {
			packet.analog_in[3].use = 1;
		}
		else {
			packet.analog_in[3].use = 0;
		}
		packet.analog_in[3].value = (short) (0x0000FFFF&Integer.parseInt(gui.txtAnalogChannelValue_4.getText(), 10));
		
		//Digital In
		if(gui.chckbxEnableDigitalInChannel_1.isSelected()) {
			packet.digital_in[0].use = 1;
		}
		else {
			packet.digital_in[0].use = 0;
		}
		packet.digital_in[0].mode = (byte) (0x00FF&gui.cmbDigitalInModeChannel_1.getSelectedIndex());
		packet.digital_in[0].modbus_address = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalInModbusAddressChannel_1.getText(), 10));
	
		if(gui.chckbxEnableDigitalInChannel_2.isSelected()) {
			packet.digital_in[1].use = 1;
		}
		else {
			packet.digital_in[1].use = 0;
		}
		packet.digital_in[1].mode = (byte) (0x00FF&gui.cmbDigitalInModeChannel_2.getSelectedIndex());
		packet.digital_in[1].modbus_address = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalInModbusAddressChannel_2.getText(), 10));
	
		//Digital Out
		if(gui.chckbxEnableDigitalOutChannel_1.isSelected()) {
			packet.digital_out[0].use = 1;
		}
		else {
			packet.digital_out[0].use = 0;
		}
		packet.digital_out[0].mode = (byte) (0x00FF&gui.cmbDigitalOutModeChannel_1.getSelectedIndex());
		if((digital_out_address_temp[0]>=digital_out_address_temp[1] && digital_out_address_temp[0]<=digital_out_address_temp[1]+1)||
				(digital_out_address_temp[0]+1>=digital_out_address_temp[1] && digital_out_address_temp[0]<=digital_out_address_temp[1]+1)) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Modbus Address input error");
			return false;
		}
		packet.digital_out[0].modbus_address = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalOutModbusAddressChannel_1.getText(), 10));
		packet.digital_out[0].high_width = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalOutHighWidthChannel_1.getText(), 10));
		packet.digital_out[0].low_width = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalOutLowWidthChannel_1.getText(), 10));
		
		if(gui.chckbxEnableDigitalOutChannel_2.isSelected()) {
			packet.digital_out[1].use = 1;
		}
		else {
			packet.digital_out[1].use = 0;
		}
		packet.digital_out[1].mode = (byte) (0x00FF&gui.cmbDigitalOutModeChannel_2.getSelectedIndex());
		packet.digital_out[1].modbus_address = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalOutModbusAddressChannel_2.getText(), 10));
		packet.digital_out[1].high_width = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalOutHighWidthChannel_2.getText(), 10));
		packet.digital_out[1].low_width = (short) (0x0000FFFF&Integer.parseInt(gui.txtDigitalOutLowWidthChannel_2.getText(), 10));
		
		//Option
		packet.options.module_name = gui.txtModuleName.getText().trim().getBytes();
		String password = new String(gui.pwdSettingPassword.getPassword());
		packet.options.pw_setting = password.trim().getBytes();
		
		packet.options.reconnection = (short) (0x0000FFFF&Integer.parseInt(gui.txtReconnection.getText(), 10));
		packet.options.transfer_interval = (short) (0x0000FFFF&Integer.parseInt(gui.txtDataTransfer.getText(), 10));
		
		packet.options.separator = gui.txtAnalogSeperator.getText().trim().getBytes();
		packet.options.form = (byte) (0x00FF&gui.cmbAnalogForm.getSelectedIndex());
		
		return true;
	}
	/* <--WizIO */
}
