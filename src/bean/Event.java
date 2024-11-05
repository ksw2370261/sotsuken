
package bean;

// Eventクラスはイベントに関する情報を保持するためのJavaBeansクラスです。
// このクラスはjava.io.Serializableインターフェースを実装し、シリアル化が可能です。
public class Event implements java.io.Serializable {

	// イベントの日付を格納するフィールド
	private String event_date;

	// イベントの時間を格納するフィールド
	private String event_time;

	// イベントの場所を格納するフィールド
	private String event_location;

	// イベントの名前を格納するフィールド
	private String event_name;

	// イベントの説明を格納するフィールド
	private String event_description;

	// event_dateフィールドの値を返すgetterメソッド
	public String getEvent_date() {
		return event_date;
	}

	// event_timeフィールドの値を返すgetterメソッド
	public String getEvent_time() {
		return event_time;
	}

	// event_locationフィールドの値を返すgetterメソッド
	public String getEvent_location() {
		return event_location;
	}

	// event_nameフィールドの値を返すgetterメソッド
	public String getEvent_name() {
		return event_name;
	}

	// event_descriptionフィールドの値を返すgetterメソッド
	public String getEvent_description() {
		return event_description;
	}

	// event_dateフィールドの値を設定するsetterメソッド
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	// event_timeフィールドの値を設定するsetterメソッド
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}

	// event_locationフィールドの値を設定するsetterメソッド
	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}

	// event_nameフィールドの値を設定するsetterメソッド
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	// event_descriptionフィールドの値を設定するsetterメソッド
	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
}
