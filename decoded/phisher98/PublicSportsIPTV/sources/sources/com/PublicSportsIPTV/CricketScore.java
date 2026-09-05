package com.PublicSportsIPTV;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSportsIPTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/PublicSportsIPTV/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/PublicSportsIPTV/CricketScore;", "", "runs", "", "overs", "", "balls", "status", "wickets", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getRuns", "()J", "getOvers", "()Ljava/lang/String;", "getBalls", "getStatus", "getWickets", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class CricketScore {

    @NotNull
    private final String balls;

    @NotNull
    private final String overs;
    private final long runs;

    @NotNull
    private final String status;
    private final long wickets;

    public static /* synthetic */ CricketScore copy$default(CricketScore cricketScore, long j, String str, String str2, String str3, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = cricketScore.runs;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = cricketScore.overs;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = cricketScore.balls;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = cricketScore.status;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            j2 = cricketScore.wickets;
        }
        return cricketScore.copy(j3, str4, str5, str6, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getRuns() {
        return this.runs;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOvers() {
        return this.overs;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBalls() {
        return this.balls;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getWickets() {
        return this.wickets;
    }

    @NotNull
    public final CricketScore copy(long runs, @NotNull String overs, @NotNull String balls, @NotNull String status, long wickets) {
        return new CricketScore(runs, overs, balls, status, wickets);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CricketScore)) {
            return false;
        }
        CricketScore cricketScore = (CricketScore) other;
        return this.runs == cricketScore.runs && Intrinsics.areEqual(this.overs, cricketScore.overs) && Intrinsics.areEqual(this.balls, cricketScore.balls) && Intrinsics.areEqual(this.status, cricketScore.status) && this.wickets == cricketScore.wickets;
    }

    public int hashCode() {
        return (((((((CricketScore$$ExternalSyntheticBackport0.m1m(this.runs) * 31) + this.overs.hashCode()) * 31) + this.balls.hashCode()) * 31) + this.status.hashCode()) * 31) + CricketScore$$ExternalSyntheticBackport0.m1m(this.wickets);
    }

    @NotNull
    public String toString() {
        return "CricketScore(runs=" + this.runs + ", overs=" + this.overs + ", balls=" + this.balls + ", status=" + this.status + ", wickets=" + this.wickets + ')';
    }

    public CricketScore(long runs, @NotNull String overs, @NotNull String balls, @NotNull String status, long wickets) {
        this.runs = runs;
        this.overs = overs;
        this.balls = balls;
        this.status = status;
        this.wickets = wickets;
    }

    public final long getRuns() {
        return this.runs;
    }

    @NotNull
    public final String getOvers() {
        return this.overs;
    }

    @NotNull
    public final String getBalls() {
        return this.balls;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public final long getWickets() {
        return this.wickets;
    }
}
