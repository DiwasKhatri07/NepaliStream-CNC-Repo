package com.cncverse;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SportzxProvider/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jh\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/cncverse/SportzxEventData;", "", "id", "", "title", "", "image", "cat", "eventInfo", "Lcom/cncverse/SportzxEventInfo;", "publish", "formatsNew", "", "Lcom/cncverse/SportzxFormat;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/cncverse/SportzxEventInfo;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getImage", "getCat", "getEventInfo", "()Lcom/cncverse/SportzxEventInfo;", "getPublish", "getFormatsNew", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/cncverse/SportzxEventInfo;Ljava/lang/String;Ljava/util/List;)Lcom/cncverse/SportzxEventData;", "equals", "", "other", "hashCode", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SportzxEventData {

    @Nullable
    private final String cat;

    @Nullable
    private final SportzxEventInfo eventInfo;

    @Nullable
    private final List<SportzxFormat> formatsNew;

    @Nullable
    private final Integer id;

    @Nullable
    private final String image;

    @Nullable
    private final String publish;

    @Nullable
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SportzxEventData copy$default(SportzxEventData sportzxEventData, Integer num, String str, String str2, String str3, SportzxEventInfo sportzxEventInfo, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = sportzxEventData.id;
        }
        if ((i & 2) != 0) {
            str = sportzxEventData.title;
        }
        if ((i & 4) != 0) {
            str2 = sportzxEventData.image;
        }
        if ((i & 8) != 0) {
            str3 = sportzxEventData.cat;
        }
        if ((i & 16) != 0) {
            sportzxEventInfo = sportzxEventData.eventInfo;
        }
        if ((i & 32) != 0) {
            str4 = sportzxEventData.publish;
        }
        if ((i & 64) != 0) {
            list = sportzxEventData.formatsNew;
        }
        String str5 = str4;
        List list2 = list;
        SportzxEventInfo sportzxEventInfo2 = sportzxEventInfo;
        String str6 = str2;
        return sportzxEventData.copy(num, str, str6, str3, sportzxEventInfo2, str5, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCat() {
        return this.cat;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SportzxEventInfo getEventInfo() {
        return this.eventInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPublish() {
        return this.publish;
    }

    @Nullable
    public final List<SportzxFormat> component7() {
        return this.formatsNew;
    }

    @NotNull
    public final SportzxEventData copy(@Nullable Integer id, @Nullable String title, @Nullable String image, @Nullable String cat, @Nullable SportzxEventInfo eventInfo, @Nullable String publish, @Nullable List<SportzxFormat> formatsNew) {
        return new SportzxEventData(id, title, image, cat, eventInfo, publish, formatsNew);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportzxEventData)) {
            return false;
        }
        SportzxEventData sportzxEventData = (SportzxEventData) other;
        return Intrinsics.areEqual(this.id, sportzxEventData.id) && Intrinsics.areEqual(this.title, sportzxEventData.title) && Intrinsics.areEqual(this.image, sportzxEventData.image) && Intrinsics.areEqual(this.cat, sportzxEventData.cat) && Intrinsics.areEqual(this.eventInfo, sportzxEventData.eventInfo) && Intrinsics.areEqual(this.publish, sportzxEventData.publish) && Intrinsics.areEqual(this.formatsNew, sportzxEventData.formatsNew);
    }

    public int hashCode() {
        return ((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.cat == null ? 0 : this.cat.hashCode())) * 31) + (this.eventInfo == null ? 0 : this.eventInfo.hashCode())) * 31) + (this.publish == null ? 0 : this.publish.hashCode())) * 31) + (this.formatsNew != null ? this.formatsNew.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SportzxEventData(id=" + this.id + ", title=" + this.title + ", image=" + this.image + ", cat=" + this.cat + ", eventInfo=" + this.eventInfo + ", publish=" + this.publish + ", formatsNew=" + this.formatsNew + ')';
    }

    public SportzxEventData(@Nullable Integer id, @Nullable String title, @Nullable String image, @Nullable String cat, @Nullable SportzxEventInfo eventInfo, @Nullable String publish, @Nullable List<SportzxFormat> list) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.cat = cat;
        this.eventInfo = eventInfo;
        this.publish = publish;
        this.formatsNew = list;
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getCat() {
        return this.cat;
    }

    @Nullable
    public final SportzxEventInfo getEventInfo() {
        return this.eventInfo;
    }

    @Nullable
    public final String getPublish() {
        return this.publish;
    }

    @Nullable
    public final List<SportzxFormat> getFormatsNew() {
        return this.formatsNew;
    }
}
