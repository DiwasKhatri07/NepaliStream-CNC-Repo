package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JT\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\nHÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/phisher98/PlaybackDecryptSource;", "", "quality", "", "label", "mime_type", "url", "bitrate_kbps", "", "height", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)V", "getQuality", "()Ljava/lang/String;", "getLabel", "getMime_type", "getUrl", "getBitrate_kbps", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/phisher98/PlaybackDecryptSource;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PlaybackDecryptSource {

    @Nullable
    private final Long bitrate_kbps;

    @Nullable
    private final Integer height;

    @Nullable
    private final String label;

    @Nullable
    private final String mime_type;

    @Nullable
    private final String quality;

    @NotNull
    private final String url;

    public static /* synthetic */ PlaybackDecryptSource copy$default(PlaybackDecryptSource playbackDecryptSource, String str, String str2, String str3, String str4, Long l, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playbackDecryptSource.quality;
        }
        if ((i & 2) != 0) {
            str2 = playbackDecryptSource.label;
        }
        if ((i & 4) != 0) {
            str3 = playbackDecryptSource.mime_type;
        }
        if ((i & 8) != 0) {
            str4 = playbackDecryptSource.url;
        }
        if ((i & 16) != 0) {
            l = playbackDecryptSource.bitrate_kbps;
        }
        if ((i & 32) != 0) {
            num = playbackDecryptSource.height;
        }
        Long l2 = l;
        Integer num2 = num;
        return playbackDecryptSource.copy(str, str2, str3, str4, l2, num2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMime_type() {
        return this.mime_type;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getBitrate_kbps() {
        return this.bitrate_kbps;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    @NotNull
    public final PlaybackDecryptSource copy(@Nullable String quality, @Nullable String label, @Nullable String mime_type, @NotNull String url, @Nullable Long bitrate_kbps, @Nullable Integer height) {
        return new PlaybackDecryptSource(quality, label, mime_type, url, bitrate_kbps, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaybackDecryptSource)) {
            return false;
        }
        PlaybackDecryptSource playbackDecryptSource = (PlaybackDecryptSource) other;
        return Intrinsics.areEqual(this.quality, playbackDecryptSource.quality) && Intrinsics.areEqual(this.label, playbackDecryptSource.label) && Intrinsics.areEqual(this.mime_type, playbackDecryptSource.mime_type) && Intrinsics.areEqual(this.url, playbackDecryptSource.url) && Intrinsics.areEqual(this.bitrate_kbps, playbackDecryptSource.bitrate_kbps) && Intrinsics.areEqual(this.height, playbackDecryptSource.height);
    }

    public int hashCode() {
        return ((((((((((this.quality == null ? 0 : this.quality.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.mime_type == null ? 0 : this.mime_type.hashCode())) * 31) + this.url.hashCode()) * 31) + (this.bitrate_kbps == null ? 0 : this.bitrate_kbps.hashCode())) * 31) + (this.height != null ? this.height.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlaybackDecryptSource(quality=" + this.quality + ", label=" + this.label + ", mime_type=" + this.mime_type + ", url=" + this.url + ", bitrate_kbps=" + this.bitrate_kbps + ", height=" + this.height + ')';
    }

    public PlaybackDecryptSource(@Nullable String quality, @Nullable String label, @Nullable String mime_type, @NotNull String url, @Nullable Long bitrate_kbps, @Nullable Integer height) {
        this.quality = quality;
        this.label = label;
        this.mime_type = mime_type;
        this.url = url;
        this.bitrate_kbps = bitrate_kbps;
        this.height = height;
    }

    public /* synthetic */ PlaybackDecryptSource(String str, String str2, String str3, String str4, Long l, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, str4, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : num);
    }

    @Nullable
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getMime_type() {
        return this.mime_type;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Long getBitrate_kbps() {
        return this.bitrate_kbps;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }
}
