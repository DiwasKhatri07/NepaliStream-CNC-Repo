package com.phisher98;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR'\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/VidlinkCaption;", "", "url", "", "language", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getLanguage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VidlinkCaption {

    @SerializedName("language")
    @Nullable
    private final String language;

    @SerializedName("url")
    @Nullable
    private final String url;

    public static /* synthetic */ VidlinkCaption copy$default(VidlinkCaption vidlinkCaption, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vidlinkCaption.url;
        }
        if ((i & 2) != 0) {
            str2 = vidlinkCaption.language;
        }
        return vidlinkCaption.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final VidlinkCaption copy(@Nullable String url, @Nullable String language) {
        return new VidlinkCaption(url, language);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VidlinkCaption)) {
            return false;
        }
        VidlinkCaption vidlinkCaption = (VidlinkCaption) other;
        return Intrinsics.areEqual(this.url, vidlinkCaption.url) && Intrinsics.areEqual(this.language, vidlinkCaption.language);
    }

    public int hashCode() {
        return ((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.language != null ? this.language.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VidlinkCaption(url=" + this.url + ", language=" + this.language + ')';
    }

    public VidlinkCaption(@Nullable String url, @Nullable String language) {
        this.url = url;
        this.language = language;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }
}
