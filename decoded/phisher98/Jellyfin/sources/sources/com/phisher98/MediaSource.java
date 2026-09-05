package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0016\b\u0003\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0016\b\u0003\u0010\u000e\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0003\u0010\u0010\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010&Jð\u0001\u00101\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0016\b\u0003\u0010\u000e\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00132\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0017:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018HÆ\u0001¢\u0006\u0002\u00102J\u0014\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u00020\u0017HÖ\u0081\u0004J\n\u00106\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&¨\u00067"}, d2 = {"Lcom/phisher98/MediaSource;", "", "transcodingUrl", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "TranscodingUrl", "path", "Path", "supportsDirectPlay", "", "SupportsDirectPlay", "protocol", "Protocol", "supportsTranscoding", "SupportsTranscoding", "supportsDirectStream", "SupportsDirectStream", "id", "Id", "container", "Container", "defaultAudioStreamIndex", "", "DefaultAudioStreamIndex", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getTranscodingUrl", "()Ljava/lang/String;", "getPath", "getSupportsDirectPlay", "()Z", "getProtocol", "getSupportsTranscoding", "getSupportsDirectStream", "getId", "getContainer", "getDefaultAudioStreamIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/MediaSource;", "equals", "other", "hashCode", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MediaSource {

    @Nullable
    private final String container;

    @Nullable
    private final Integer defaultAudioStreamIndex;

    @Nullable
    private final String id;

    @Nullable
    private final String path;

    @NotNull
    private final String protocol;
    private final boolean supportsDirectPlay;
    private final boolean supportsDirectStream;
    private final boolean supportsTranscoding;

    @Nullable
    private final String transcodingUrl;

    public MediaSource() {
        this(null, null, false, null, false, false, null, null, null, 511, null);
    }

    public static /* synthetic */ MediaSource copy$default(MediaSource mediaSource, String str, String str2, boolean z, String str3, boolean z2, boolean z3, String str4, String str5, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mediaSource.transcodingUrl;
        }
        if ((i & 2) != 0) {
            str2 = mediaSource.path;
        }
        if ((i & 4) != 0) {
            z = mediaSource.supportsDirectPlay;
        }
        if ((i & 8) != 0) {
            str3 = mediaSource.protocol;
        }
        if ((i & 16) != 0) {
            z2 = mediaSource.supportsTranscoding;
        }
        if ((i & 32) != 0) {
            z3 = mediaSource.supportsDirectStream;
        }
        if ((i & 64) != 0) {
            str4 = mediaSource.id;
        }
        if ((i & 128) != 0) {
            str5 = mediaSource.container;
        }
        if ((i & 256) != 0) {
            num = mediaSource.defaultAudioStreamIndex;
        }
        String str6 = str5;
        Integer num2 = num;
        boolean z4 = z3;
        String str7 = str4;
        boolean z5 = z2;
        boolean z6 = z;
        return mediaSource.copy(str, str2, z6, str3, z5, z4, str7, str6, num2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTranscodingUrl() {
        return this.transcodingUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSupportsDirectPlay() {
        return this.supportsDirectPlay;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getProtocol() {
        return this.protocol;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getSupportsTranscoding() {
        return this.supportsTranscoding;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getSupportsDirectStream() {
        return this.supportsDirectStream;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getContainer() {
        return this.container;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getDefaultAudioStreamIndex() {
        return this.defaultAudioStreamIndex;
    }

    @NotNull
    public final MediaSource copy(@JsonProperty("TranscodingUrl") @Nullable String transcodingUrl, @JsonProperty("Path") @Nullable String path, @JsonProperty("SupportsDirectPlay") boolean supportsDirectPlay, @JsonProperty("Protocol") @NotNull String protocol, @JsonProperty("SupportsTranscoding") boolean supportsTranscoding, @JsonProperty("SupportsDirectStream") boolean supportsDirectStream, @JsonProperty("Id") @Nullable String id, @JsonProperty("Container") @Nullable String container, @JsonProperty("DefaultAudioStreamIndex") @Nullable Integer defaultAudioStreamIndex) {
        return new MediaSource(transcodingUrl, path, supportsDirectPlay, protocol, supportsTranscoding, supportsDirectStream, id, container, defaultAudioStreamIndex);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaSource)) {
            return false;
        }
        MediaSource mediaSource = (MediaSource) other;
        return Intrinsics.areEqual(this.transcodingUrl, mediaSource.transcodingUrl) && Intrinsics.areEqual(this.path, mediaSource.path) && this.supportsDirectPlay == mediaSource.supportsDirectPlay && Intrinsics.areEqual(this.protocol, mediaSource.protocol) && this.supportsTranscoding == mediaSource.supportsTranscoding && this.supportsDirectStream == mediaSource.supportsDirectStream && Intrinsics.areEqual(this.id, mediaSource.id) && Intrinsics.areEqual(this.container, mediaSource.container) && Intrinsics.areEqual(this.defaultAudioStreamIndex, mediaSource.defaultAudioStreamIndex);
    }

    public int hashCode() {
        return ((((((((((((((((this.transcodingUrl == null ? 0 : this.transcodingUrl.hashCode()) * 31) + (this.path == null ? 0 : this.path.hashCode())) * 31) + MediaSource$$ExternalSyntheticBackport0.m2m(this.supportsDirectPlay)) * 31) + this.protocol.hashCode()) * 31) + MediaSource$$ExternalSyntheticBackport0.m2m(this.supportsTranscoding)) * 31) + MediaSource$$ExternalSyntheticBackport0.m2m(this.supportsDirectStream)) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.container == null ? 0 : this.container.hashCode())) * 31) + (this.defaultAudioStreamIndex != null ? this.defaultAudioStreamIndex.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MediaSource(transcodingUrl=" + this.transcodingUrl + ", path=" + this.path + ", supportsDirectPlay=" + this.supportsDirectPlay + ", protocol=" + this.protocol + ", supportsTranscoding=" + this.supportsTranscoding + ", supportsDirectStream=" + this.supportsDirectStream + ", id=" + this.id + ", container=" + this.container + ", defaultAudioStreamIndex=" + this.defaultAudioStreamIndex + ')';
    }

    public MediaSource(@JsonProperty("TranscodingUrl") @Nullable String transcodingUrl, @JsonProperty("Path") @Nullable String path, @JsonProperty("SupportsDirectPlay") boolean supportsDirectPlay, @JsonProperty("Protocol") @NotNull String protocol, @JsonProperty("SupportsTranscoding") boolean supportsTranscoding, @JsonProperty("SupportsDirectStream") boolean supportsDirectStream, @JsonProperty("Id") @Nullable String id, @JsonProperty("Container") @Nullable String container, @JsonProperty("DefaultAudioStreamIndex") @Nullable Integer defaultAudioStreamIndex) {
        this.transcodingUrl = transcodingUrl;
        this.path = path;
        this.supportsDirectPlay = supportsDirectPlay;
        this.protocol = protocol;
        this.supportsTranscoding = supportsTranscoding;
        this.supportsDirectStream = supportsDirectStream;
        this.id = id;
        this.container = container;
        this.defaultAudioStreamIndex = defaultAudioStreamIndex;
    }

    public /* synthetic */ MediaSource(String str, String str2, boolean z, String str3, boolean z2, boolean z3, String str4, String str5, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : num);
    }

    @Nullable
    public final String getTranscodingUrl() {
        return this.transcodingUrl;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    public final boolean getSupportsDirectPlay() {
        return this.supportsDirectPlay;
    }

    @NotNull
    public final String getProtocol() {
        return this.protocol;
    }

    public final boolean getSupportsTranscoding() {
        return this.supportsTranscoding;
    }

    public final boolean getSupportsDirectStream() {
        return this.supportsDirectStream;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getContainer() {
        return this.container;
    }

    @Nullable
    public final Integer getDefaultAudioStreamIndex() {
        return this.defaultAudioStreamIndex;
    }
}
