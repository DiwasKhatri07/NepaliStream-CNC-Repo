package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0007\u0010\u0002¨\u0006!"}, d2 = {"Lcom/MPlayer/MXPlayer;", "", "style", "", "totalCount", "", "next", "previous", "items", "", "Lcom/MPlayer/Item;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getStyle", "()Ljava/lang/String;", "getTotalCount", "()J", "getNext", "getPrevious", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MXPlayer {

    @NotNull
    private final List<Item> items;

    @NotNull
    private final String next;

    @NotNull
    private final String previous;

    @NotNull
    private final String style;
    private final long totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MXPlayer copy$default(MXPlayer mXPlayer, String str, long j, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mXPlayer.style;
        }
        if ((i & 2) != 0) {
            j = mXPlayer.totalCount;
        }
        if ((i & 4) != 0) {
            str2 = mXPlayer.next;
        }
        if ((i & 8) != 0) {
            str3 = mXPlayer.previous;
        }
        if ((i & 16) != 0) {
            list = mXPlayer.items;
        }
        List list2 = list;
        String str4 = str2;
        return mXPlayer.copy(str, j, str4, str3, list2);
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
    public final List<Item> component5() {
        return this.items;
    }

    @NotNull
    public final MXPlayer copy(@NotNull String style, long totalCount, @NotNull String next, @NotNull String previous, @NotNull List<Item> items) {
        return new MXPlayer(style, totalCount, next, previous, items);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MXPlayer)) {
            return false;
        }
        MXPlayer mXPlayer = (MXPlayer) other;
        return Intrinsics.areEqual(this.style, mXPlayer.style) && this.totalCount == mXPlayer.totalCount && Intrinsics.areEqual(this.next, mXPlayer.next) && Intrinsics.areEqual(this.previous, mXPlayer.previous) && Intrinsics.areEqual(this.items, mXPlayer.items);
    }

    public int hashCode() {
        return (((((((this.style.hashCode() * 31) + MXPlayer$$ExternalSyntheticBackport0.m15m(this.totalCount)) * 31) + this.next.hashCode()) * 31) + this.previous.hashCode()) * 31) + this.items.hashCode();
    }

    @NotNull
    public String toString() {
        return "MXPlayer(style=" + this.style + ", totalCount=" + this.totalCount + ", next=" + this.next + ", previous=" + this.previous + ", items=" + this.items + ')';
    }

    public MXPlayer(@NotNull String style, long totalCount, @NotNull String next, @NotNull String previous, @NotNull List<Item> list) {
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
    public final List<Item> getItems() {
        return this.items;
    }
}
