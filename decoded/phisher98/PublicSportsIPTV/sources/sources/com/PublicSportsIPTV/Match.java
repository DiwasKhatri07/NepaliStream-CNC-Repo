package com.PublicSportsIPTV;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSportsIPTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/PublicSportsIPTV/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÙ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\u0011:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0018\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0003:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0003:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a\u0012\u0016\b\u0001\u0010\u001b\u001a\u00020\u001c:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0011HÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u001cHÆ\u0003Jï\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\u0016\b\u0003\u0010\u0010\u001a\u00020\u0011:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0003:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0003:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a2\u0016\b\u0003\u0010\u001b\u001a\u00020\u001c:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001dHÆ\u0001J\u0014\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010G\u001a\u00020HHÖ\u0081\u0004J\n\u0010I\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006J"}, d2 = {"Lcom/PublicSportsIPTV/Match;", "", "category", "", "title", "tournament", "matchId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "match_id", "status", "streamingStatus", "startTime", "startDate", "image", "imageCdn", "Lcom/PublicSportsIPTV/ImageCdn;", "image_cdn", "teams", "", "Lcom/PublicSportsIPTV/Team;", "language", "adfreeStream", "adfree_stream", "daiStream", "dai_stream", "streamingCdn", "Lcom/PublicSportsIPTV/StreamingCdn;", "STREAMING_CDN", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/PublicSportsIPTV/ImageCdn;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/PublicSportsIPTV/StreamingCdn;)V", "getCategory", "()Ljava/lang/String;", "getTitle", "getTournament", "getMatchId", "()J", "getStatus", "getStreamingStatus", "getStartTime", "getStartDate", "getImage", "getImageCdn", "()Lcom/PublicSportsIPTV/ImageCdn;", "getTeams", "()Ljava/util/List;", "getLanguage", "getAdfreeStream", "getDaiStream", "getStreamingCdn", "()Lcom/PublicSportsIPTV/StreamingCdn;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "", "toString", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Match {

    @Nullable
    private final String adfreeStream;

    @NotNull
    private final String category;

    @Nullable
    private final String daiStream;

    @NotNull
    private final String image;

    @NotNull
    private final ImageCdn imageCdn;

    @NotNull
    private final String language;
    private final long matchId;

    @NotNull
    private final String startDate;

    @NotNull
    private final String startTime;

    @NotNull
    private final String status;

    @NotNull
    private final StreamingCdn streamingCdn;

    @NotNull
    private final String streamingStatus;

    @NotNull
    private final List<Team> teams;

    @NotNull
    private final String title;

    @NotNull
    private final String tournament;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Match copy$default(Match match, String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, String str8, ImageCdn imageCdn, List list, String str9, String str10, String str11, StreamingCdn streamingCdn, int i, Object obj) {
        String str12 = (i & 1) != 0 ? match.category : str;
        return match.copy(str12, (i & 2) != 0 ? match.title : str2, (i & 4) != 0 ? match.tournament : str3, (i & 8) != 0 ? match.matchId : j, (i & 16) != 0 ? match.status : str4, (i & 32) != 0 ? match.streamingStatus : str5, (i & 64) != 0 ? match.startTime : str6, (i & 128) != 0 ? match.startDate : str7, (i & 256) != 0 ? match.image : str8, (i & 512) != 0 ? match.imageCdn : imageCdn, (i & 1024) != 0 ? match.teams : list, (i & 2048) != 0 ? match.language : str9, (i & 4096) != 0 ? match.adfreeStream : str10, (i & 8192) != 0 ? match.daiStream : str11, (i & 16384) != 0 ? match.streamingCdn : streamingCdn);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ImageCdn getImageCdn() {
        return this.imageCdn;
    }

    @NotNull
    public final List<Team> component11() {
        return this.teams;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getAdfreeStream() {
        return this.adfreeStream;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getDaiStream() {
        return this.daiStream;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final StreamingCdn getStreamingCdn() {
        return this.streamingCdn;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTournament() {
        return this.tournament;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getMatchId() {
        return this.matchId;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStreamingStatus() {
        return this.streamingStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStartDate() {
        return this.startDate;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final Match copy(@NotNull String category, @NotNull String title, @NotNull String tournament, @JsonProperty("match_id") long matchId, @NotNull String status, @NotNull String streamingStatus, @NotNull String startTime, @NotNull String startDate, @NotNull String image, @JsonProperty("image_cdn") @NotNull ImageCdn imageCdn, @NotNull List<Team> teams, @NotNull String language, @JsonProperty("adfree_stream") @Nullable String adfreeStream, @JsonProperty("dai_stream") @Nullable String daiStream, @JsonProperty("STREAMING_CDN") @NotNull StreamingCdn streamingCdn) {
        return new Match(category, title, tournament, matchId, status, streamingStatus, startTime, startDate, image, imageCdn, teams, language, adfreeStream, daiStream, streamingCdn);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Match)) {
            return false;
        }
        Match match = (Match) other;
        return Intrinsics.areEqual(this.category, match.category) && Intrinsics.areEqual(this.title, match.title) && Intrinsics.areEqual(this.tournament, match.tournament) && this.matchId == match.matchId && Intrinsics.areEqual(this.status, match.status) && Intrinsics.areEqual(this.streamingStatus, match.streamingStatus) && Intrinsics.areEqual(this.startTime, match.startTime) && Intrinsics.areEqual(this.startDate, match.startDate) && Intrinsics.areEqual(this.image, match.image) && Intrinsics.areEqual(this.imageCdn, match.imageCdn) && Intrinsics.areEqual(this.teams, match.teams) && Intrinsics.areEqual(this.language, match.language) && Intrinsics.areEqual(this.adfreeStream, match.adfreeStream) && Intrinsics.areEqual(this.daiStream, match.daiStream) && Intrinsics.areEqual(this.streamingCdn, match.streamingCdn);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.category.hashCode() * 31) + this.title.hashCode()) * 31) + this.tournament.hashCode()) * 31) + Match$$ExternalSyntheticBackport0.m2m(this.matchId)) * 31) + this.status.hashCode()) * 31) + this.streamingStatus.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.startDate.hashCode()) * 31) + this.image.hashCode()) * 31) + this.imageCdn.hashCode()) * 31) + this.teams.hashCode()) * 31) + this.language.hashCode()) * 31) + (this.adfreeStream == null ? 0 : this.adfreeStream.hashCode())) * 31) + (this.daiStream != null ? this.daiStream.hashCode() : 0)) * 31) + this.streamingCdn.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Match(category=").append(this.category).append(", title=").append(this.title).append(", tournament=").append(this.tournament).append(", matchId=").append(this.matchId).append(", status=").append(this.status).append(", streamingStatus=").append(this.streamingStatus).append(", startTime=").append(this.startTime).append(", startDate=").append(this.startDate).append(", image=").append(this.image).append(", imageCdn=").append(this.imageCdn).append(", teams=").append(this.teams).append(", language=");
        sb.append(this.language).append(", adfreeStream=").append(this.adfreeStream).append(", daiStream=").append(this.daiStream).append(", streamingCdn=").append(this.streamingCdn).append(')');
        return sb.toString();
    }

    public Match(@NotNull String category, @NotNull String title, @NotNull String tournament, @JsonProperty("match_id") long matchId, @NotNull String status, @NotNull String streamingStatus, @NotNull String startTime, @NotNull String startDate, @NotNull String image, @JsonProperty("image_cdn") @NotNull ImageCdn imageCdn, @NotNull List<Team> list, @NotNull String language, @JsonProperty("adfree_stream") @Nullable String adfreeStream, @JsonProperty("dai_stream") @Nullable String daiStream, @JsonProperty("STREAMING_CDN") @NotNull StreamingCdn streamingCdn) {
        this.category = category;
        this.title = title;
        this.tournament = tournament;
        this.matchId = matchId;
        this.status = status;
        this.streamingStatus = streamingStatus;
        this.startTime = startTime;
        this.startDate = startDate;
        this.image = image;
        this.imageCdn = imageCdn;
        this.teams = list;
        this.language = language;
        this.adfreeStream = adfreeStream;
        this.daiStream = daiStream;
        this.streamingCdn = streamingCdn;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getTournament() {
        return this.tournament;
    }

    public final long getMatchId() {
        return this.matchId;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getStreamingStatus() {
        return this.streamingStatus;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getStartDate() {
        return this.startDate;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final ImageCdn getImageCdn() {
        return this.imageCdn;
    }

    @NotNull
    public final List<Team> getTeams() {
        return this.teams;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getAdfreeStream() {
        return this.adfreeStream;
    }

    @Nullable
    public final String getDaiStream() {
        return this.daiStream;
    }

    @NotNull
    public final StreamingCdn getStreamingCdn() {
        return this.streamingCdn;
    }
}
