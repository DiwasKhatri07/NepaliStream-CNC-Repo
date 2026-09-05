package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/MapplePowInfo;", "", "challenge", "", "challengeId", "difficulty", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getChallenge", "()Ljava/lang/String;", "getChallengeId", "getDifficulty", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/MapplePowInfo;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MapplePowInfo {

    @Nullable
    private final String challenge;

    @Nullable
    private final String challengeId;

    @Nullable
    private final Integer difficulty;

    public MapplePowInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MapplePowInfo copy$default(MapplePowInfo mapplePowInfo, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mapplePowInfo.challenge;
        }
        if ((i & 2) != 0) {
            str2 = mapplePowInfo.challengeId;
        }
        if ((i & 4) != 0) {
            num = mapplePowInfo.difficulty;
        }
        return mapplePowInfo.copy(str, str2, num);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChallenge() {
        return this.challenge;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChallengeId() {
        return this.challengeId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDifficulty() {
        return this.difficulty;
    }

    @NotNull
    public final MapplePowInfo copy(@Nullable String challenge, @Nullable String challengeId, @Nullable Integer difficulty) {
        return new MapplePowInfo(challenge, challengeId, difficulty);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapplePowInfo)) {
            return false;
        }
        MapplePowInfo mapplePowInfo = (MapplePowInfo) other;
        return Intrinsics.areEqual(this.challenge, mapplePowInfo.challenge) && Intrinsics.areEqual(this.challengeId, mapplePowInfo.challengeId) && Intrinsics.areEqual(this.difficulty, mapplePowInfo.difficulty);
    }

    public int hashCode() {
        return ((((this.challenge == null ? 0 : this.challenge.hashCode()) * 31) + (this.challengeId == null ? 0 : this.challengeId.hashCode())) * 31) + (this.difficulty != null ? this.difficulty.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MapplePowInfo(challenge=" + this.challenge + ", challengeId=" + this.challengeId + ", difficulty=" + this.difficulty + ')';
    }

    public MapplePowInfo(@Nullable String challenge, @Nullable String challengeId, @Nullable Integer difficulty) {
        this.challenge = challenge;
        this.challengeId = challengeId;
        this.difficulty = difficulty;
    }

    public /* synthetic */ MapplePowInfo(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
    }

    @Nullable
    public final String getChallenge() {
        return this.challenge;
    }

    @Nullable
    public final String getChallengeId() {
        return this.challengeId;
    }

    @Nullable
    public final Integer getDifficulty() {
        return this.difficulty;
    }
}
