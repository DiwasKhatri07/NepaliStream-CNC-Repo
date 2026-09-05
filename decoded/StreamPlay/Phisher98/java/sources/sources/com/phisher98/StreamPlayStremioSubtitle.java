package com.phisher98;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR'\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR'\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/phisher98/StreamPlayStremioSubtitle;", "", "url", "", "lang", "langCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getLang", "getLangCode", "lang_code", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class StreamPlayStremioSubtitle {

    @SerializedName("lang")
    @Nullable
    private final String lang;

    @SerializedName("lang_code")
    @Nullable
    private final String langCode;

    @SerializedName("url")
    @Nullable
    private final String url;

    public StreamPlayStremioSubtitle() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ StreamPlayStremioSubtitle copy$default(StreamPlayStremioSubtitle streamPlayStremioSubtitle, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamPlayStremioSubtitle.url;
        }
        if ((i & 2) != 0) {
            str2 = streamPlayStremioSubtitle.lang;
        }
        if ((i & 4) != 0) {
            str3 = streamPlayStremioSubtitle.langCode;
        }
        return streamPlayStremioSubtitle.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLangCode() {
        return this.langCode;
    }

    @NotNull
    public final StreamPlayStremioSubtitle copy(@Nullable String url, @Nullable String lang, @Nullable String langCode) {
        return new StreamPlayStremioSubtitle(url, lang, langCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamPlayStremioSubtitle)) {
            return false;
        }
        StreamPlayStremioSubtitle streamPlayStremioSubtitle = (StreamPlayStremioSubtitle) other;
        return Intrinsics.areEqual(this.url, streamPlayStremioSubtitle.url) && Intrinsics.areEqual(this.lang, streamPlayStremioSubtitle.lang) && Intrinsics.areEqual(this.langCode, streamPlayStremioSubtitle.langCode);
    }

    public int hashCode() {
        return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.lang == null ? 0 : this.lang.hashCode())) * 31) + (this.langCode != null ? this.langCode.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "StreamPlayStremioSubtitle(url=" + this.url + ", lang=" + this.lang + ", langCode=" + this.langCode + ')';
    }

    public StreamPlayStremioSubtitle(@Nullable String url, @Nullable String lang, @Nullable String langCode) {
        this.url = url;
        this.lang = lang;
        this.langCode = langCode;
    }

    public /* synthetic */ StreamPlayStremioSubtitle(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Nullable
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    public final String getLangCode() {
        return this.langCode;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
