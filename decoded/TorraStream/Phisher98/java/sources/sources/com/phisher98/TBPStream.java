package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/phisher98/TBPStream;", "", "name", "", "title", "infoHash", "tag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getTitle", "getInfoHash", "getTag", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TBPStream {

    @NotNull
    private final String infoHash;

    @NotNull
    private final String name;

    @NotNull
    private final String tag;

    @NotNull
    private final String title;

    public static /* synthetic */ TBPStream copy$default(TBPStream tBPStream, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tBPStream.name;
        }
        if ((i & 2) != 0) {
            str2 = tBPStream.title;
        }
        if ((i & 4) != 0) {
            str3 = tBPStream.infoHash;
        }
        if ((i & 8) != 0) {
            str4 = tBPStream.tag;
        }
        return tBPStream.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInfoHash() {
        return this.infoHash;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final TBPStream copy(@NotNull String name, @NotNull String title, @NotNull String infoHash, @NotNull String tag) {
        return new TBPStream(name, title, infoHash, tag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TBPStream)) {
            return false;
        }
        TBPStream tBPStream = (TBPStream) other;
        return Intrinsics.areEqual(this.name, tBPStream.name) && Intrinsics.areEqual(this.title, tBPStream.title) && Intrinsics.areEqual(this.infoHash, tBPStream.infoHash) && Intrinsics.areEqual(this.tag, tBPStream.tag);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.title.hashCode()) * 31) + this.infoHash.hashCode()) * 31) + this.tag.hashCode();
    }

    @NotNull
    public String toString() {
        return "TBPStream(name=" + this.name + ", title=" + this.title + ", infoHash=" + this.infoHash + ", tag=" + this.tag + ')';
    }

    public TBPStream(@NotNull String name, @NotNull String title, @NotNull String infoHash, @NotNull String tag) {
        this.name = name;
        this.title = title;
        this.infoHash = infoHash;
        this.tag = tag;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getInfoHash() {
        return this.infoHash;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }
}
