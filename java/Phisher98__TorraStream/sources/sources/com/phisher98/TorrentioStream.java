package com.phisher98;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR'\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR'\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR)\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/phisher98/TorrentioStream;", "", "name", "", "title", "infoHash", "fileIdx", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getTitle", "getInfoHash", "getFileIdx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/TorrentioStream;", "equals", "", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TorrentioStream {

    @SerializedName("fileIdx")
    @Nullable
    private final Integer fileIdx;

    @SerializedName("infoHash")
    @Nullable
    private final String infoHash;

    @SerializedName("name")
    @Nullable
    private final String name;

    @SerializedName("title")
    @Nullable
    private final String title;

    public TorrentioStream() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TorrentioStream copy$default(TorrentioStream torrentioStream, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = torrentioStream.name;
        }
        if ((i & 2) != 0) {
            str2 = torrentioStream.title;
        }
        if ((i & 4) != 0) {
            str3 = torrentioStream.infoHash;
        }
        if ((i & 8) != 0) {
            num = torrentioStream.fileIdx;
        }
        return torrentioStream.copy(str, str2, str3, num);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInfoHash() {
        return this.infoHash;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getFileIdx() {
        return this.fileIdx;
    }

    @NotNull
    public final TorrentioStream copy(@Nullable String name, @Nullable String title, @Nullable String infoHash, @Nullable Integer fileIdx) {
        return new TorrentioStream(name, title, infoHash, fileIdx);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TorrentioStream)) {
            return false;
        }
        TorrentioStream torrentioStream = (TorrentioStream) other;
        return Intrinsics.areEqual(this.name, torrentioStream.name) && Intrinsics.areEqual(this.title, torrentioStream.title) && Intrinsics.areEqual(this.infoHash, torrentioStream.infoHash) && Intrinsics.areEqual(this.fileIdx, torrentioStream.fileIdx);
    }

    public int hashCode() {
        return ((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.infoHash == null ? 0 : this.infoHash.hashCode())) * 31) + (this.fileIdx != null ? this.fileIdx.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TorrentioStream(name=" + this.name + ", title=" + this.title + ", infoHash=" + this.infoHash + ", fileIdx=" + this.fileIdx + ')';
    }

    public TorrentioStream(@Nullable String name, @Nullable String title, @Nullable String infoHash, @Nullable Integer fileIdx) {
        this.name = name;
        this.title = title;
        this.infoHash = infoHash;
        this.fileIdx = fileIdx;
    }

    public /* synthetic */ TorrentioStream(String str, String str2, String str3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num);
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
    public final String getInfoHash() {
        return this.infoHash;
    }

    @Nullable
    public final Integer getFileIdx() {
        return this.fileIdx;
    }
}
