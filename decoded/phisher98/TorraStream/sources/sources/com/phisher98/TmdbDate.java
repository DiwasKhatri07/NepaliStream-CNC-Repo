package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/phisher98/TmdbDate;", "", "today", "", "nextWeek", "lastWeekStart", "monthStart", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToday", "()Ljava/lang/String;", "getNextWeek", "getLastWeekStart", "getMonthStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TmdbDate {

    @NotNull
    private final String lastWeekStart;

    @NotNull
    private final String monthStart;

    @NotNull
    private final String nextWeek;

    @NotNull
    private final String today;

    public static /* synthetic */ TmdbDate copy$default(TmdbDate tmdbDate, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tmdbDate.today;
        }
        if ((i & 2) != 0) {
            str2 = tmdbDate.nextWeek;
        }
        if ((i & 4) != 0) {
            str3 = tmdbDate.lastWeekStart;
        }
        if ((i & 8) != 0) {
            str4 = tmdbDate.monthStart;
        }
        return tmdbDate.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToday() {
        return this.today;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNextWeek() {
        return this.nextWeek;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLastWeekStart() {
        return this.lastWeekStart;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMonthStart() {
        return this.monthStart;
    }

    @NotNull
    public final TmdbDate copy(@NotNull String today, @NotNull String nextWeek, @NotNull String lastWeekStart, @NotNull String monthStart) {
        return new TmdbDate(today, nextWeek, lastWeekStart, monthStart);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TmdbDate)) {
            return false;
        }
        TmdbDate tmdbDate = (TmdbDate) other;
        return Intrinsics.areEqual(this.today, tmdbDate.today) && Intrinsics.areEqual(this.nextWeek, tmdbDate.nextWeek) && Intrinsics.areEqual(this.lastWeekStart, tmdbDate.lastWeekStart) && Intrinsics.areEqual(this.monthStart, tmdbDate.monthStart);
    }

    public int hashCode() {
        return (((((this.today.hashCode() * 31) + this.nextWeek.hashCode()) * 31) + this.lastWeekStart.hashCode()) * 31) + this.monthStart.hashCode();
    }

    @NotNull
    public String toString() {
        return "TmdbDate(today=" + this.today + ", nextWeek=" + this.nextWeek + ", lastWeekStart=" + this.lastWeekStart + ", monthStart=" + this.monthStart + ')';
    }

    public TmdbDate(@NotNull String today, @NotNull String nextWeek, @NotNull String lastWeekStart, @NotNull String monthStart) {
        this.today = today;
        this.nextWeek = nextWeek;
        this.lastWeekStart = lastWeekStart;
        this.monthStart = monthStart;
    }

    @NotNull
    public final String getToday() {
        return this.today;
    }

    @NotNull
    public final String getNextWeek() {
        return this.nextWeek;
    }

    @NotNull
    public final String getLastWeekStart() {
        return this.lastWeekStart;
    }

    @NotNull
    public final String getMonthStart() {
        return this.monthStart;
    }
}
