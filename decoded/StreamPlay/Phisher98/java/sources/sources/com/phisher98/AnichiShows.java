package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/phisher98/AnichiShows;", "", "pageInfo", "Lcom/phisher98/PageInfo;", "edges", "", "Lcom/phisher98/Edge;", "<init>", "(Lcom/phisher98/PageInfo;Ljava/util/List;)V", "getPageInfo", "()Lcom/phisher98/PageInfo;", "getEdges", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiShows {

    @NotNull
    private final List<Edge> edges;

    @NotNull
    private final PageInfo pageInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnichiShows copy$default(AnichiShows anichiShows, PageInfo pageInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            pageInfo = anichiShows.pageInfo;
        }
        if ((i & 2) != 0) {
            list = anichiShows.edges;
        }
        return anichiShows.copy(pageInfo, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PageInfo getPageInfo() {
        return this.pageInfo;
    }

    @NotNull
    public final List<Edge> component2() {
        return this.edges;
    }

    @NotNull
    public final AnichiShows copy(@NotNull PageInfo pageInfo, @NotNull List<Edge> edges) {
        return new AnichiShows(pageInfo, edges);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnichiShows)) {
            return false;
        }
        AnichiShows anichiShows = (AnichiShows) other;
        return Intrinsics.areEqual(this.pageInfo, anichiShows.pageInfo) && Intrinsics.areEqual(this.edges, anichiShows.edges);
    }

    public int hashCode() {
        return (this.pageInfo.hashCode() * 31) + this.edges.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnichiShows(pageInfo=" + this.pageInfo + ", edges=" + this.edges + ')';
    }

    public AnichiShows(@NotNull PageInfo pageInfo, @NotNull List<Edge> list) {
        this.pageInfo = pageInfo;
        this.edges = list;
    }

    @NotNull
    public final PageInfo getPageInfo() {
        return this.pageInfo;
    }

    @NotNull
    public final List<Edge> getEdges() {
        return this.edges;
    }
}
