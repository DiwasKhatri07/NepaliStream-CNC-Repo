package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003JZ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/phisher98/TorrentsDBStream;", "", "name", "", "title", "infoHash", "fileIdx", "", "behaviorHints", "Lcom/phisher98/TorrentsDBBehaviorHints;", "sources", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/phisher98/TorrentsDBBehaviorHints;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getTitle", "getInfoHash", "getFileIdx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBehaviorHints", "()Lcom/phisher98/TorrentsDBBehaviorHints;", "getSources", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/phisher98/TorrentsDBBehaviorHints;Ljava/util/List;)Lcom/phisher98/TorrentsDBStream;", "equals", "", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TorrentsDBStream {

    @Nullable
    private final TorrentsDBBehaviorHints behaviorHints;

    @Nullable
    private final Integer fileIdx;

    @NotNull
    private final String infoHash;

    @Nullable
    private final String name;

    @Nullable
    private final List<String> sources;

    @Nullable
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TorrentsDBStream copy$default(TorrentsDBStream torrentsDBStream, String str, String str2, String str3, Integer num, TorrentsDBBehaviorHints torrentsDBBehaviorHints, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = torrentsDBStream.name;
        }
        if ((i & 2) != 0) {
            str2 = torrentsDBStream.title;
        }
        if ((i & 4) != 0) {
            str3 = torrentsDBStream.infoHash;
        }
        if ((i & 8) != 0) {
            num = torrentsDBStream.fileIdx;
        }
        if ((i & 16) != 0) {
            torrentsDBBehaviorHints = torrentsDBStream.behaviorHints;
        }
        if ((i & 32) != 0) {
            list = torrentsDBStream.sources;
        }
        TorrentsDBBehaviorHints torrentsDBBehaviorHints2 = torrentsDBBehaviorHints;
        List list2 = list;
        return torrentsDBStream.copy(str, str2, str3, num, torrentsDBBehaviorHints2, list2);
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

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInfoHash() {
        return this.infoHash;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getFileIdx() {
        return this.fileIdx;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TorrentsDBBehaviorHints getBehaviorHints() {
        return this.behaviorHints;
    }

    @Nullable
    public final List<String> component6() {
        return this.sources;
    }

    @NotNull
    public final TorrentsDBStream copy(@Nullable String name, @Nullable String title, @NotNull String infoHash, @Nullable Integer fileIdx, @Nullable TorrentsDBBehaviorHints behaviorHints, @Nullable List<String> sources) {
        return new TorrentsDBStream(name, title, infoHash, fileIdx, behaviorHints, sources);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TorrentsDBStream)) {
            return false;
        }
        TorrentsDBStream torrentsDBStream = (TorrentsDBStream) other;
        return Intrinsics.areEqual(this.name, torrentsDBStream.name) && Intrinsics.areEqual(this.title, torrentsDBStream.title) && Intrinsics.areEqual(this.infoHash, torrentsDBStream.infoHash) && Intrinsics.areEqual(this.fileIdx, torrentsDBStream.fileIdx) && Intrinsics.areEqual(this.behaviorHints, torrentsDBStream.behaviorHints) && Intrinsics.areEqual(this.sources, torrentsDBStream.sources);
    }

    public int hashCode() {
        return ((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + this.infoHash.hashCode()) * 31) + (this.fileIdx == null ? 0 : this.fileIdx.hashCode())) * 31) + (this.behaviorHints == null ? 0 : this.behaviorHints.hashCode())) * 31) + (this.sources != null ? this.sources.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TorrentsDBStream(name=" + this.name + ", title=" + this.title + ", infoHash=" + this.infoHash + ", fileIdx=" + this.fileIdx + ", behaviorHints=" + this.behaviorHints + ", sources=" + this.sources + ')';
    }

    public TorrentsDBStream(@Nullable String name, @Nullable String title, @NotNull String infoHash, @Nullable Integer fileIdx, @Nullable TorrentsDBBehaviorHints behaviorHints, @Nullable List<String> list) {
        this.name = name;
        this.title = title;
        this.infoHash = infoHash;
        this.fileIdx = fileIdx;
        this.behaviorHints = behaviorHints;
        this.sources = list;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getInfoHash() {
        return this.infoHash;
    }

    @Nullable
    public final Integer getFileIdx() {
        return this.fileIdx;
    }

    @Nullable
    public final TorrentsDBBehaviorHints getBehaviorHints() {
        return this.behaviorHints;
    }

    @Nullable
    public final List<String> getSources() {
        return this.sources;
    }
}
