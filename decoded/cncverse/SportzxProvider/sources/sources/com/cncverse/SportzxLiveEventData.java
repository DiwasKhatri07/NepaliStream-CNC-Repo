package com.cncverse;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SportzxProvider/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003Jg\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001J\u0014\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/cncverse/SportzxLiveEventData;", "", "id", "", "title", "", "image", "eventId", "cat", "eventInfo", "Lcom/cncverse/SportzxLiveEventInfo;", "publish", "formats", "", "Lcom/cncverse/SportzxLiveEventFormat;", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/cncverse/SportzxLiveEventInfo;ILjava/util/List;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getImage", "getEventId", "getCat", "getEventInfo", "()Lcom/cncverse/SportzxLiveEventInfo;", "getPublish", "getFormats", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SportzxLiveEventData {

    @Nullable
    private final String cat;
    private final int eventId;

    @Nullable
    private final SportzxLiveEventInfo eventInfo;

    @Nullable
    private final List<SportzxLiveEventFormat> formats;
    private final int id;

    @Nullable
    private final String image;
    private final int publish;

    @NotNull
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SportzxLiveEventData copy$default(SportzxLiveEventData sportzxLiveEventData, int i, String str, String str2, int i2, String str3, SportzxLiveEventInfo sportzxLiveEventInfo, int i3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sportzxLiveEventData.id;
        }
        if ((i4 & 2) != 0) {
            str = sportzxLiveEventData.title;
        }
        if ((i4 & 4) != 0) {
            str2 = sportzxLiveEventData.image;
        }
        if ((i4 & 8) != 0) {
            i2 = sportzxLiveEventData.eventId;
        }
        if ((i4 & 16) != 0) {
            str3 = sportzxLiveEventData.cat;
        }
        if ((i4 & 32) != 0) {
            sportzxLiveEventInfo = sportzxLiveEventData.eventInfo;
        }
        if ((i4 & 64) != 0) {
            i3 = sportzxLiveEventData.publish;
        }
        if ((i4 & 128) != 0) {
            list = sportzxLiveEventData.formats;
        }
        int i5 = i3;
        List list2 = list;
        String str4 = str3;
        SportzxLiveEventInfo sportzxLiveEventInfo2 = sportzxLiveEventInfo;
        return sportzxLiveEventData.copy(i, str, str2, i2, str4, sportzxLiveEventInfo2, i5, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getEventId() {
        return this.eventId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCat() {
        return this.cat;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SportzxLiveEventInfo getEventInfo() {
        return this.eventInfo;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getPublish() {
        return this.publish;
    }

    @Nullable
    public final List<SportzxLiveEventFormat> component8() {
        return this.formats;
    }

    @NotNull
    public final SportzxLiveEventData copy(int id, @NotNull String title, @Nullable String image, int eventId, @Nullable String cat, @Nullable SportzxLiveEventInfo eventInfo, int publish, @Nullable List<SportzxLiveEventFormat> formats) {
        return new SportzxLiveEventData(id, title, image, eventId, cat, eventInfo, publish, formats);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportzxLiveEventData)) {
            return false;
        }
        SportzxLiveEventData sportzxLiveEventData = (SportzxLiveEventData) other;
        return this.id == sportzxLiveEventData.id && Intrinsics.areEqual(this.title, sportzxLiveEventData.title) && Intrinsics.areEqual(this.image, sportzxLiveEventData.image) && this.eventId == sportzxLiveEventData.eventId && Intrinsics.areEqual(this.cat, sportzxLiveEventData.cat) && Intrinsics.areEqual(this.eventInfo, sportzxLiveEventData.eventInfo) && this.publish == sportzxLiveEventData.publish && Intrinsics.areEqual(this.formats, sportzxLiveEventData.formats);
    }

    public int hashCode() {
        return (((((((((((((this.id * 31) + this.title.hashCode()) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + this.eventId) * 31) + (this.cat == null ? 0 : this.cat.hashCode())) * 31) + (this.eventInfo == null ? 0 : this.eventInfo.hashCode())) * 31) + this.publish) * 31) + (this.formats != null ? this.formats.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SportzxLiveEventData(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", eventId=" + this.eventId + ", cat=" + this.cat + ", eventInfo=" + this.eventInfo + ", publish=" + this.publish + ", formats=" + this.formats + ')';
    }

    public SportzxLiveEventData(int id, @NotNull String title, @Nullable String image, int eventId, @Nullable String cat, @Nullable SportzxLiveEventInfo eventInfo, int publish, @Nullable List<SportzxLiveEventFormat> list) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.eventId = eventId;
        this.cat = cat;
        this.eventInfo = eventInfo;
        this.publish = publish;
        this.formats = list;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    public final int getEventId() {
        return this.eventId;
    }

    @Nullable
    public final String getCat() {
        return this.cat;
    }

    @Nullable
    public final SportzxLiveEventInfo getEventInfo() {
        return this.eventInfo;
    }

    public final int getPublish() {
        return this.publish;
    }

    @Nullable
    public final List<SportzxLiveEventFormat> getFormats() {
        return this.formats;
    }
}
