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

	// イベントの短縮版内容を格納するフィールド
	private String shortContent;

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

	// shortContentフィールドの値を返すgetterメソッド
	public String getShortContent() {
		return shortContent;
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
		// イベントの内容が変更されたときに短縮版を自動生成
		setShortContent(generateShortContent(eventContent));
	}

	// shortContentフィールドの値を設定するsetterメソッド
	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	/**
	 * イベントの内容から短縮版を生成するメソッド
	 * @param content イベント内容
	 * @return 短縮版の内容（50文字以内 + "..."）
	 */
	private String generateShortContent(String content) {
		if (content != null && content.length() > 50) {
			return content.substring(0, 50) + "...";
		} else {
			return content;
		}
	}
}
