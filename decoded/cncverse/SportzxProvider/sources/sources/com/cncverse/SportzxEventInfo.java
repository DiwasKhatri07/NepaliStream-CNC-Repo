package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SportzxProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006-"}, d2 = {"Lcom/cncverse/SportzxEventInfo;", "", "teamA", "", "teamB", "teamAFlag", "teamBFlag", "eventName", "eventType", "eventBanner", "eventLogo", "isHot", "startTime", "endTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTeamA", "()Ljava/lang/String;", "getTeamB", "getTeamAFlag", "getTeamBFlag", "getEventName", "getEventType", "getEventBanner", "getEventLogo", "getStartTime", "getEndTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SportzxEventInfo {

    @Nullable
    private final String endTime;

    @Nullable
    private final String eventBanner;

    @Nullable
    private final String eventLogo;

    @Nullable
    private final String eventName;

    @Nullable
    private final String eventType;

    @Nullable
    private final String isHot;

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

    public static /* synthetic */ SportzxEventInfo copy$default(SportzxEventInfo sportzxEventInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sportzxEventInfo.teamA;
        }
        if ((i & 2) != 0) {
            str2 = sportzxEventInfo.teamB;
        }
        if ((i & 4) != 0) {
            str3 = sportzxEventInfo.teamAFlag;
        }
        if ((i & 8) != 0) {
            str4 = sportzxEventInfo.teamBFlag;
        }
        if ((i & 16) != 0) {
            str5 = sportzxEventInfo.eventName;
        }
        if ((i & 32) != 0) {
            str6 = sportzxEventInfo.eventType;
        }
        if ((i & 64) != 0) {
            str7 = sportzxEventInfo.eventBanner;
        }
        if ((i & 128) != 0) {
            str8 = sportzxEventInfo.eventLogo;
        }
        if ((i & 256) != 0) {
            str9 = sportzxEventInfo.isHot;
        }
        if ((i & 512) != 0) {
            str10 = sportzxEventInfo.startTime;
        }
        if ((i & 1024) != 0) {
            str11 = sportzxEventInfo.endTime;
        }
        String str12 = str10;
        String str13 = str11;
        String str14 = str8;
        String str15 = str9;
        String str16 = str6;
        String str17 = str7;
        String str18 = str5;
        String str19 = str3;
        return sportzxEventInfo.copy(str, str2, str19, str4, str18, str16, str17, str14, str15, str12, str13);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTeamA() {
        return this.teamA;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTeamB() {
        return this.teamB;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTeamAFlag() {
        return this.teamAFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTeamBFlag() {
        return this.teamBFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getEventBanner() {
        return this.eventBanner;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getEventLogo() {
        return this.eventLogo;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getIsHot() {
        return this.isHot;
    }

    @NotNull
    public final SportzxEventInfo copy(@Nullable String teamA, @Nullable String teamB, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String eventName, @Nullable String eventType, @Nullable String eventBanner, @Nullable String eventLogo, @Nullable String isHot, @Nullable String startTime, @Nullable String endTime) {
        return new SportzxEventInfo(teamA, teamB, teamAFlag, teamBFlag, eventName, eventType, eventBanner, eventLogo, isHot, startTime, endTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportzxEventInfo)) {
            return false;
        }
        SportzxEventInfo sportzxEventInfo = (SportzxEventInfo) other;
        return Intrinsics.areEqual(this.teamA, sportzxEventInfo.teamA) && Intrinsics.areEqual(this.teamB, sportzxEventInfo.teamB) && Intrinsics.areEqual(this.teamAFlag, sportzxEventInfo.teamAFlag) && Intrinsics.areEqual(this.teamBFlag, sportzxEventInfo.teamBFlag) && Intrinsics.areEqual(this.eventName, sportzxEventInfo.eventName) && Intrinsics.areEqual(this.eventType, sportzxEventInfo.eventType) && Intrinsics.areEqual(this.eventBanner, sportzxEventInfo.eventBanner) && Intrinsics.areEqual(this.eventLogo, sportzxEventInfo.eventLogo) && Intrinsics.areEqual(this.isHot, sportzxEventInfo.isHot) && Intrinsics.areEqual(this.startTime, sportzxEventInfo.startTime) && Intrinsics.areEqual(this.endTime, sportzxEventInfo.endTime);
    }

    public int hashCode() {
        return ((((((((((((((((((((this.teamA == null ? 0 : this.teamA.hashCode()) * 31) + (this.teamB == null ? 0 : this.teamB.hashCode())) * 31) + (this.teamAFlag == null ? 0 : this.teamAFlag.hashCode())) * 31) + (this.teamBFlag == null ? 0 : this.teamBFlag.hashCode())) * 31) + (this.eventName == null ? 0 : this.eventName.hashCode())) * 31) + (this.eventType == null ? 0 : this.eventType.hashCode())) * 31) + (this.eventBanner == null ? 0 : this.eventBanner.hashCode())) * 31) + (this.eventLogo == null ? 0 : this.eventLogo.hashCode())) * 31) + (this.isHot == null ? 0 : this.isHot.hashCode())) * 31) + (this.startTime == null ? 0 : this.startTime.hashCode())) * 31) + (this.endTime != null ? this.endTime.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SportzxEventInfo(teamA=").append(this.teamA).append(", teamB=").append(this.teamB).append(", teamAFlag=").append(this.teamAFlag).append(", teamBFlag=").append(this.teamBFlag).append(", eventName=").append(this.eventName).append(", eventType=").append(this.eventType).append(", eventBanner=").append(this.eventBanner).append(", eventLogo=").append(this.eventLogo).append(", isHot=").append(this.isHot).append(", startTime=").append(this.startTime).append(", endTime=").append(this.endTime).append(')');
        return sb.toString();
    }

    public SportzxEventInfo(@Nullable String teamA, @Nullable String teamB, @Nullable String teamAFlag, @Nullable String teamBFlag, @Nullable String eventName, @Nullable String eventType, @Nullable String eventBanner, @Nullable String eventLogo, @Nullable String isHot, @Nullable String startTime, @Nullable String endTime) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamAFlag = teamAFlag;
        this.teamBFlag = teamBFlag;
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventBanner = eventBanner;
        this.eventLogo = eventLogo;
        this.isHot = isHot;
        this.startTime = startTime;
        this.endTime = endTime;
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
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    public final String getEventType() {
        return this.eventType;
    }

    @Nullable
    public final String getEventBanner() {
        return this.eventBanner;
    }

    @Nullable
    public final String getEventLogo() {
        return this.eventLogo;
    }

    @Nullable
    public final String isHot() {
        return this.isHot;
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
