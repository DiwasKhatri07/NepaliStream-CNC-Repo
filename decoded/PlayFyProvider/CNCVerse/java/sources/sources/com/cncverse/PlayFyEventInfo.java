package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayFyProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayFyProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\nHÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\t\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006*"}, d2 = {"Lcom/cncverse/PlayFyEventInfo;", "", "eventName", "", "teamA", "teamB", "teamAFlag", "teamBFlag", "eventBanner", "isPinned", "", "startTime", "endTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "getTeamA", "getTeamB", "getTeamAFlag", "getTeamBFlag", "getEventBanner", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStartTime", "getEndTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/PlayFyEventInfo;", "equals", "", "other", "hashCode", "toString", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayFyEventInfo {

    @Nullable
    private final String endTime;

    @Nullable
    private final String eventBanner;

    @Nullable
    private final String eventName;

    @Nullable
    private final Integer isPinned;

    @Nullable
    private final String startTime;

    @Nullable
    private final String teamA;

    @Nullable
    private final String teamAFlag;

    @Nullable
    private final String teamB;

    @Nullable
    private final String teamBFlag;

    public static /* synthetic */ PlayFyEventInfo copy$default(PlayFyEventInfo playFyEventInfo, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playFyEventInfo.eventName;
        }
        if ((i & 2) != 0) {
            str2 = playFyEventInfo.teamA;
        }
        if ((i & 4) != 0) {
            str3 = playFyEventInfo.teamB;
        }
        if ((i & 8) != 0) {
            str4 = playFyEventInfo.teamAFlag;
        }
        if ((i & 16) != 0) {
            str5 = playFyEventInfo.teamBFlag;
        }
        if ((i & 32) != 0) {
            str6 = playFyEventInfo.eventBanner;
        }
        if ((i & 64) != 0) {
            num = playFyEventInfo.isPinned;
        }
        if ((i & 128) != 0) {
            str7 = playFyEventInfo.startTime;
        }
        if ((i & 256) != 0) {
            str8 = playFyEventInfo.endTime;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str6;
        Integer num2 = num;
        String str12 = str5;
        String str13 = str3;
        return playFyEventInfo.copy(str, str2, str13, str4, str12, str11, num2, str9, str10);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeamA() {
        return this.teamA;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTeamB() {
        return this.teamB;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTeamAFlag() {
        return this.teamAFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTeamBFlag() {
        return this.teamBFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEventBanner() {
        return this.eventBanner;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getIsPinned() {
        return this.isPinned;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final PlayFyEventInfo copy(@Nullable String eventName, @Nullable String teamA, @Nullable String teamB, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String eventBanner, @Nullable Integer isPinned, @Nullable String startTime, @Nullable String endTime) {
        return new PlayFyEventInfo(eventName, teamA, teamB, teamAFlag, teamBFlag, eventBanner, isPinned, startTime, endTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayFyEventInfo)) {
            return false;
        }
        PlayFyEventInfo playFyEventInfo = (PlayFyEventInfo) other;
        return Intrinsics.areEqual(this.eventName, playFyEventInfo.eventName) && Intrinsics.areEqual(this.teamA, playFyEventInfo.teamA) && Intrinsics.areEqual(this.teamB, playFyEventInfo.teamB) && Intrinsics.areEqual(this.teamAFlag, playFyEventInfo.teamAFlag) && Intrinsics.areEqual(this.teamBFlag, playFyEventInfo.teamBFlag) && Intrinsics.areEqual(this.eventBanner, playFyEventInfo.eventBanner) && Intrinsics.areEqual(this.isPinned, playFyEventInfo.isPinned) && Intrinsics.areEqual(this.startTime, playFyEventInfo.startTime) && Intrinsics.areEqual(this.endTime, playFyEventInfo.endTime);
    }

    public int hashCode() {
        return ((((((((((((((((this.eventName == null ? 0 : this.eventName.hashCode()) * 31) + (this.teamA == null ? 0 : this.teamA.hashCode())) * 31) + (this.teamB == null ? 0 : this.teamB.hashCode())) * 31) + (this.teamAFlag == null ? 0 : this.teamAFlag.hashCode())) * 31) + (this.teamBFlag == null ? 0 : this.teamBFlag.hashCode())) * 31) + (this.eventBanner == null ? 0 : this.eventBanner.hashCode())) * 31) + (this.isPinned == null ? 0 : this.isPinned.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.endTime != null ? this.endTime.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlayFyEventInfo(eventName=" + this.eventName + ", teamA=" + this.teamA + ", teamB=" + this.teamB + ", teamAFlag=" + this.teamAFlag + ", teamBFlag=" + this.teamBFlag + ", eventBanner=" + this.eventBanner + ", isPinned=" + this.isPinned + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }

    public PlayFyEventInfo(@Nullable String eventName, @Nullable String teamA, @Nullable String teamB, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String eventBanner, @Nullable Integer isPinned, @Nullable String startTime, @Nullable String endTime) {
        this.eventName = eventName;
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamAFlag = teamAFlag;
        this.teamBFlag = teamBFlag;
        this.eventBanner = eventBanner;
        this.isPinned = isPinned;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Nullable
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    public final String getTeamA() {
        return this.teamA;
    }

    @Nullable
    public final String getTeamB() {
        return this.teamB;
    }

    @Nullable
    public final String getTeamAFlag() {
        return this.teamAFlag;
    }

    @Nullable
    public final String getTeamBFlag() {
        return this.teamBFlag;
    }

    @Nullable
    public final String getEventBanner() {
        return this.eventBanner;
    }

    @Nullable
    public final Integer isPinned() {
        return this.isPinned;
    }

    @Nullable
    public final String getStartTime() {
        return this.startTime;
    }

    @Nullable
    public final String getEndTime() {
        return this.endTime;
    }
}
