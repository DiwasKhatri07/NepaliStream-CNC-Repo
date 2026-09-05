package com.MPlayer;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/MPlayer/MovieRoot;", "", "style", "", "totalCount", "", "next", "previous", "items", "", "Lcom/MPlayer/MovieItem;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getStyle", "()Ljava/lang/String;", "getTotalCount", "()J", "getNext", "getPrevious", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieRoot {

    @NotNull
    private final List<MovieItem> items;

    @NotNull
    private final String next;

    @NotNull
    private final String previous;

    @NotNull
    private final String style;
    private final long totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MovieRoot copy$default(MovieRoot movieRoot, String str, long j, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = movieRoot.style;
        }
        if ((i & 2) != 0) {
            j = movieRoot.totalCount;
        }
        if ((i & 4) != 0) {
            str2 = movieRoot.next;
        }
        if ((i & 8) != 0) {
            str3 = movieRoot.previous;
        }
        if ((i & 16) != 0) {
            list = movieRoot.items;
        }
        List list2 = list;
        String str4 = str2;
        return movieRoot.copy(str, j, str4, str3, list2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTotalCount() {
        return this.totalCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNext() {
        return this.next;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPrevious() {
        return this.previous;
    }

    @NotNull
    public final List<MovieItem> component5() {
        return this.items;
    }

    @NotNull
    public final MovieRoot copy(@NotNull String style, long totalCount, @NotNull String next, @NotNull String previous, @NotNull List<MovieItem> items) {
        return new MovieRoot(style, totalCount, next, previous, items);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieRoot)) {
            return false;
        }
        MovieRoot movieRoot = (MovieRoot) other;
        return Intrinsics.areEqual(this.style, movieRoot.style) && this.totalCount == movieRoot.totalCount && Intrinsics.areEqual(this.next, movieRoot.next) && Intrinsics.areEqual(this.previous, movieRoot.previous) && Intrinsics.areEqual(this.items, movieRoot.items);
    }

    public int hashCode() {
        return (((((((this.style.hashCode() * 31) + MovieRoot$$ExternalSyntheticBackport0.m25m(this.totalCount)) * 31) + this.next.hashCode()) * 31) + this.previous.hashCode()) * 31) + this.items.hashCode();
    }

    @NotNull
    public String toString() {
        return "MovieRoot(style=" + this.style + ", totalCount=" + this.totalCount + ", next=" + this.next + ", previous=" + this.previous + ", items=" + this.items + ')';
    }

    public MovieRoot(@NotNull String style, long totalCount, @NotNull String next, @NotNull String previous, @NotNull List<MovieItem> list) {
        this.style = style;
        this.totalCount = totalCount;
        this.next = next;
        this.previous = previous;
        this.items = list;
    }

    @NotNull
    public final String getStyle() {
        return this.style;
    }

    public final long getTotalCount() {
        return this.totalCount;
    }

    @NotNull
    public final String getNext() {
        return this.next;
    }

    @NotNull
    public final String getPrevious() {
        return this.previous;
    }

    @NotNull
    public final List<MovieItem> getItems() {
        return this.items;
    }
}
