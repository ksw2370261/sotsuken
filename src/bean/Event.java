package bean;

// Eventクラスはイベントに関する情報を保持するためのJavaBeansクラスです。
// このクラスはjava.io.Serializableインターフェースを実装し、シリアル化が可能です。
public class Event implements java.io.Serializable {

	// イベントコード（主キー）を格納するフィールド
	private int eventCd;

	// イベントの日付を格納するフィールド
	private String eventDate;

	// イベントの時間を格納するフィールド
	private String eventTime;

	// イベントの場所を格納するフィールド
	private String eventLocation;

	// イベントの名前を格納するフィールド
	private String eventName;

	// イベントの内容を格納するフィールド
	private String eventContent;

	// eventCdフィールドの値を返すgetterメソッド
	public int getEventCd() {
		return eventCd;
	}

	// eventDateフィールドの値を返すgetterメソッド
	public String getEventDate() {
		return eventDate;
	}

	// eventTimeフィールドの値を返すgetterメソッド
	public String getEventTime() {
		return eventTime;
	}

	// eventLocationフィールドの値を返すgetterメソッド
	public String getEventLocation() {
		return eventLocation;
	}

	// eventNameフィールドの値を返すgetterメソッド
	public String getEventName() {
		return eventName;
	}

	// eventContentフィールドの値を返すgetterメソッド
	public String getEventContent() {
		return eventContent;
	}

	// eventCdフィールドの値を設定するsetterメソッド
	public void setEventCd(int eventCd) {
		this.eventCd = eventCd;
	}

	// eventDateフィールドの値を設定するsetterメソッド
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	// eventTimeフィールドの値を設定するsetterメソッド
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	// eventLocationフィールドの値を設定するsetterメソッド
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	// eventNameフィールドの値を設定するsetterメソッド
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	// eventContentフィールドの値を設定するsetterメソッド
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
}
