package com.phisher98;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\rHÆ\u0003J\u009a\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\rHÆ\u0001¢\u0006\u0002\u00102J\u0014\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u00020\u000bHÖ\u0081\u0004J\n\u00107\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R'\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R'\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R'\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R'\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R'\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R)\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\n¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R'\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"¨\u00068"}, d2 = {"Lcom/phisher98/StreamPlayStremioStream;", "", "name", "", "title", "description", "url", "externalUrl", "ytId", "infoHash", "fileIdx", "", "sources", "", "behaviorHints", "Lcom/phisher98/StreamPlayStremioBehaviorHints;", "subtitles", "Lcom/phisher98/StreamPlayStremioSubtitle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/phisher98/StreamPlayStremioBehaviorHints;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getTitle", "getDescription", "getUrl", "getExternalUrl", "getYtId", "getInfoHash", "getFileIdx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSources", "()Ljava/util/List;", "getBehaviorHints", "()Lcom/phisher98/StreamPlayStremioBehaviorHints;", "getSubtitles", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/phisher98/StreamPlayStremioBehaviorHints;Ljava/util/List;)Lcom/phisher98/StreamPlayStremioStream;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class StreamPlayStremioStream {

    @SerializedName("behaviorHints")
    @Nullable
    private final StreamPlayStremioBehaviorHints behaviorHints;

    @SerializedName("description")
    @Nullable
    private final String description;

    @SerializedName("externalUrl")
    @Nullable
    private final String externalUrl;

    @SerializedName("fileIdx")
    @Nullable
    private final Integer fileIdx;

    @SerializedName("infoHash")
    @Nullable
    private final String infoHash;

    @SerializedName("name")
    @Nullable
    private final String name;

    @SerializedName("sources")
    @NotNull
    private final List<String> sources;

    @SerializedName("subtitles")
    @NotNull
    private final List<StreamPlayStremioSubtitle> subtitles;

    @SerializedName("title")
    @Nullable
    private final String title;

    @SerializedName("url")
    @Nullable
    private final String url;

    @SerializedName("ytId")
    @Nullable
    private final String ytId;

    public StreamPlayStremioStream() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StreamPlayStremioStream copy$default(StreamPlayStremioStream streamPlayStremioStream, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, List list, StreamPlayStremioBehaviorHints streamPlayStremioBehaviorHints, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamPlayStremioStream.name;
        }
        if ((i & 2) != 0) {
            str2 = streamPlayStremioStream.title;
        }
        if ((i & 4) != 0) {
            str3 = streamPlayStremioStream.description;
        }
        if ((i & 8) != 0) {
            str4 = streamPlayStremioStream.url;
        }
        if ((i & 16) != 0) {
            str5 = streamPlayStremioStream.externalUrl;
        }
        if ((i & 32) != 0) {
            str6 = streamPlayStremioStream.ytId;
        }
        if ((i & 64) != 0) {
            str7 = streamPlayStremioStream.infoHash;
        }
        if ((i & 128) != 0) {
            num = streamPlayStremioStream.fileIdx;
        }
        if ((i & 256) != 0) {
            list = streamPlayStremioStream.sources;
        }
        if ((i & 512) != 0) {
            streamPlayStremioBehaviorHints = streamPlayStremioStream.behaviorHints;
        }
        if ((i & 1024) != 0) {
            list2 = streamPlayStremioStream.subtitles;
        }
        StreamPlayStremioBehaviorHints streamPlayStremioBehaviorHints2 = streamPlayStremioBehaviorHints;
        List list3 = list2;
        Integer num2 = num;
        List list4 = list;
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return streamPlayStremioStream.copy(str, str2, str11, str4, str10, str8, str9, num2, list4, streamPlayStremioBehaviorHints2, list3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final StreamPlayStremioBehaviorHints getBehaviorHints() {
        return this.behaviorHints;
    }

    @NotNull
    public final List<StreamPlayStremioSubtitle> component11() {
        return this.subtitles;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getExternalUrl() {
        return this.externalUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getYtId() {
        return this.ytId;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getInfoHash() {
        return this.infoHash;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getFileIdx() {
        return this.fileIdx;
    }

    @NotNull
    public final List<String> component9() {
        return this.sources;
    }

    @NotNull
    public final StreamPlayStremioStream copy(@Nullable String name, @Nullable String title, @Nullable String description, @Nullable String url, @Nullable String externalUrl, @Nullable String ytId, @Nullable String infoHash, @Nullable Integer fileIdx, @NotNull List<String> sources, @Nullable StreamPlayStremioBehaviorHints behaviorHints, @NotNull List<StreamPlayStremioSubtitle> subtitles) {
        return new StreamPlayStremioStream(name, title, description, url, externalUrl, ytId, infoHash, fileIdx, sources, behaviorHints, subtitles);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamPlayStremioStream)) {
            return false;
        }
        StreamPlayStremioStream streamPlayStremioStream = (StreamPlayStremioStream) other;
        return Intrinsics.areEqual(this.name, streamPlayStremioStream.name) && Intrinsics.areEqual(this.title, streamPlayStremioStream.title) && Intrinsics.areEqual(this.description, streamPlayStremioStream.description) && Intrinsics.areEqual(this.url, streamPlayStremioStream.url) && Intrinsics.areEqual(this.externalUrl, streamPlayStremioStream.externalUrl) && Intrinsics.areEqual(this.ytId, streamPlayStremioStream.ytId) && Intrinsics.areEqual(this.infoHash, streamPlayStremioStream.infoHash) && Intrinsics.areEqual(this.fileIdx, streamPlayStremioStream.fileIdx) && Intrinsics.areEqual(this.sources, streamPlayStremioStream.sources) && Intrinsics.areEqual(this.behaviorHints, streamPlayStremioStream.behaviorHints) && Intrinsics.areEqual(this.subtitles, streamPlayStremioStream.subtitles);
    }

    public int hashCode() {
        return ((((((((((((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.externalUrl == null ? 0 : this.externalUrl.hashCode())) * 31) + (this.ytId == null ? 0 : this.ytId.hashCode())) * 31) + (this.infoHash == null ? 0 : this.infoHash.hashCode())) * 31) + (this.fileIdx == null ? 0 : this.fileIdx.hashCode())) * 31) + this.sources.hashCode()) * 31) + (this.behaviorHints != null ? this.behaviorHints.hashCode() : 0)) * 31) + this.subtitles.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StreamPlayStremioStream(name=").append(this.name).append(", title=").append(this.title).append(", description=").append(this.description).append(", url=").append(this.url).append(", externalUrl=").append(this.externalUrl).append(", ytId=").append(this.ytId).append(", infoHash=").append(this.infoHash).append(", fileIdx=").append(this.fileIdx).append(", sources=").append(this.sources).append(", behaviorHints=").append(this.behaviorHints).append(", subtitles=").append(this.subtitles).append(')');
        return sb.toString();
    }

    public StreamPlayStremioStream(@Nullable String name, @Nullable String title, @Nullable String description, @Nullable String url, @Nullable String externalUrl, @Nullable String ytId, @Nullable String infoHash, @Nullable Integer fileIdx, @NotNull List<String> list, @Nullable StreamPlayStremioBehaviorHints behaviorHints, @NotNull List<StreamPlayStremioSubtitle> list2) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.url = url;
        this.externalUrl = externalUrl;
        this.ytId = ytId;
        this.infoHash = infoHash;
        this.fileIdx = fileIdx;
        this.sources = list;
        this.behaviorHints = behaviorHints;
        this.subtitles = list2;
    }

    public /* synthetic */ StreamPlayStremioStream(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, List list, StreamPlayStremioBehaviorHints streamPlayStremioBehaviorHints, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : num, (i & 256) != 0 ? CollectionsKt.emptyList() : list, (i & 512) != 0 ? null : streamPlayStremioBehaviorHints, (i & 1024) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getExternalUrl() {
        return this.externalUrl;
    }

    @Nullable
    public final String getYtId() {
        return this.ytId;
    }

    @Nullable
    public final String getInfoHash() {
        return this.infoHash;
    }

    @Nullable
    public final Integer getFileIdx() {
        return this.fileIdx;
    }

    @NotNull
    public final List<String> getSources() {
        return this.sources;
    }

    @Nullable
    public final StreamPlayStremioBehaviorHints getBehaviorHints() {
        return this.behaviorHints;
    }

    @NotNull
    public final List<StreamPlayStremioSubtitle> getSubtitles() {
        return this.subtitles;
    }
}
