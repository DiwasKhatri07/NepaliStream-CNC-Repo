package com.PublicSportsIPTV;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSportsIPTVParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PublicSportsIPTV/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0090\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00102J\u0014\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u000206HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0007\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00068"}, d2 = {"Lcom/PublicSportsIPTV/Team;", "", "name", "", "shortName", "flag", "Lcom/PublicSportsIPTV/Flag;", "isWinner", "", "color", "cricketScore", "", "Lcom/PublicSportsIPTV/CricketScore;", "kabaddiScore", "footballScore", "basketBallScore", "hockeyScore", "status", "Lcom/PublicSportsIPTV/Status;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/PublicSportsIPTV/Flag;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/PublicSportsIPTV/Status;)V", "getName", "()Ljava/lang/String;", "getShortName", "getFlag", "()Lcom/PublicSportsIPTV/Flag;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getColor", "getCricketScore", "()Ljava/util/List;", "getKabaddiScore", "()Ljava/lang/Object;", "getFootballScore", "getBasketBallScore", "getHockeyScore", "getStatus", "()Lcom/PublicSportsIPTV/Status;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/PublicSportsIPTV/Flag;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/PublicSportsIPTV/Status;)Lcom/PublicSportsIPTV/Team;", "equals", "other", "hashCode", "", "toString", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Team {

    @Nullable
    private final Object basketBallScore;

    @NotNull
    private final String color;

    @Nullable
    private final List<CricketScore> cricketScore;

    @NotNull
    private final Flag flag;

    @Nullable
    private final Object footballScore;

    @Nullable
    private final Object hockeyScore;

    @Nullable
    private final Boolean isWinner;

    @Nullable
    private final Object kabaddiScore;

    @NotNull
    private final String name;

    @NotNull
    private final String shortName;

    @Nullable
    private final Status status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Team copy$default(Team team, String str, String str2, Flag flag, Boolean bool, String str3, List list, Object obj, Object obj2, Object obj3, Object obj4, Status status, int i, Object obj5) {
        if ((i & 1) != 0) {
            str = team.name;
        }
        if ((i & 2) != 0) {
            str2 = team.shortName;
        }
        if ((i & 4) != 0) {
            flag = team.flag;
        }
        if ((i & 8) != 0) {
            bool = team.isWinner;
        }
        if ((i & 16) != 0) {
            str3 = team.color;
        }
        if ((i & 32) != 0) {
            list = team.cricketScore;
        }
        if ((i & 64) != 0) {
            obj = team.kabaddiScore;
        }
        if ((i & 128) != 0) {
            obj2 = team.footballScore;
        }
        if ((i & 256) != 0) {
            obj3 = team.basketBallScore;
        }
        if ((i & 512) != 0) {
            obj4 = team.hockeyScore;
        }
        if ((i & 1024) != 0) {
            status = team.status;
        }
        Object obj6 = obj4;
        Status status2 = status;
        Object obj7 = obj2;
        Object obj8 = obj3;
        List list2 = list;
        Object obj9 = obj;
        String str4 = str3;
        Flag flag2 = flag;
        return team.copy(str, str2, flag2, bool, str4, list2, obj9, obj7, obj8, obj6, status2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Object getHockeyScore() {
        return this.hockeyScore;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getShortName() {
        return this.shortName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Flag getFlag() {
        return this.flag;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsWinner() {
        return this.isWinner;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final List<CricketScore> component6() {
        return this.cricketScore;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getKabaddiScore() {
        return this.kabaddiScore;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Object getFootballScore() {
        return this.footballScore;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Object getBasketBallScore() {
        return this.basketBallScore;
    }

    @NotNull
    public final Team copy(@NotNull String name, @NotNull String shortName, @NotNull Flag flag, @Nullable Boolean isWinner, @NotNull String color, @Nullable List<CricketScore> cricketScore, @Nullable Object kabaddiScore, @Nullable Object footballScore, @Nullable Object basketBallScore, @Nullable Object hockeyScore, @Nullable Status status) {
        return new Team(name, shortName, flag, isWinner, color, cricketScore, kabaddiScore, footballScore, basketBallScore, hockeyScore, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Team)) {
            return false;
        }
        Team team = (Team) other;
        return Intrinsics.areEqual(this.name, team.name) && Intrinsics.areEqual(this.shortName, team.shortName) && Intrinsics.areEqual(this.flag, team.flag) && Intrinsics.areEqual(this.isWinner, team.isWinner) && Intrinsics.areEqual(this.color, team.color) && Intrinsics.areEqual(this.cricketScore, team.cricketScore) && Intrinsics.areEqual(this.kabaddiScore, team.kabaddiScore) && Intrinsics.areEqual(this.footballScore, team.footballScore) && Intrinsics.areEqual(this.basketBallScore, team.basketBallScore) && Intrinsics.areEqual(this.hockeyScore, team.hockeyScore) && Intrinsics.areEqual(this.status, team.status);
    }

    public int hashCode() {
        return (((((((((((((((((((this.name.hashCode() * 31) + this.shortName.hashCode()) * 31) + this.flag.hashCode()) * 31) + (this.isWinner == null ? 0 : this.isWinner.hashCode())) * 31) + this.color.hashCode()) * 31) + (this.cricketScore == null ? 0 : this.cricketScore.hashCode())) * 31) + (this.kabaddiScore == null ? 0 : this.kabaddiScore.hashCode())) * 31) + (this.footballScore == null ? 0 : this.footballScore.hashCode())) * 31) + (this.basketBallScore == null ? 0 : this.basketBallScore.hashCode())) * 31) + (this.hockeyScore == null ? 0 : this.hockeyScore.hashCode())) * 31) + (this.status != null ? this.status.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team(name=").append(this.name).append(", shortName=").append(this.shortName).append(", flag=").append(this.flag).append(", isWinner=").append(this.isWinner).append(", color=").append(this.color).append(", cricketScore=").append(this.cricketScore).append(", kabaddiScore=").append(this.kabaddiScore).append(", footballScore=").append(this.footballScore).append(", basketBallScore=").append(this.basketBallScore).append(", hockeyScore=").append(this.hockeyScore).append(", status=").append(this.status).append(')');
        return sb.toString();
    }

    public Team(@NotNull String name, @NotNull String shortName, @NotNull Flag flag, @Nullable Boolean isWinner, @NotNull String color, @Nullable List<CricketScore> list, @Nullable Object kabaddiScore, @Nullable Object footballScore, @Nullable Object basketBallScore, @Nullable Object hockeyScore, @Nullable Status status) {
        this.name = name;
        this.shortName = shortName;
        this.flag = flag;
        this.isWinner = isWinner;
        this.color = color;
        this.cricketScore = list;
        this.kabaddiScore = kabaddiScore;
        this.footballScore = footballScore;
        this.basketBallScore = basketBallScore;
        this.hockeyScore = hockeyScore;
        this.status = status;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getShortName() {
        return this.shortName;
    }

    @NotNull
    public final Flag getFlag() {
        return this.flag;
    }

    @Nullable
    public final Boolean isWinner() {
        return this.isWinner;
    }

    @NotNull
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final List<CricketScore> getCricketScore() {
        return this.cricketScore;
    }

    @Nullable
    public final Object getKabaddiScore() {
        return this.kabaddiScore;
    }

    @Nullable
    public final Object getFootballScore() {
        return this.footballScore;
    }

    @Nullable
    public final Object getBasketBallScore() {
        return this.basketBallScore;
    }

    @Nullable
    public final Object getHockeyScore() {
        return this.hockeyScore;
    }

    @Nullable
    public final Status getStatus() {
        return this.status;
    }
}
