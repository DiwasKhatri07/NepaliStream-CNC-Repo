package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JH\u0010\u0013\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u001e\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR-\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u001b"}, d2 = {"Lcom/AniVortex/SeasonEpisodesResponse;", "", "seasonId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "season_id", "episodes", "", "Lcom/AniVortex/EpisodeInfo;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "getSeasonId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisodes", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/AniVortex/SeasonEpisodesResponse;", "equals", "", "other", "hashCode", "toString", "", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SeasonEpisodesResponse {

    @JsonProperty("episodes")
    @Nullable
    private final List<EpisodeInfo> episodes;

    @JsonProperty("season_id")
    @Nullable
    private final Integer seasonId;

    /* JADX WARN: Multi-variable type inference failed */
    public SeasonEpisodesResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SeasonEpisodesResponse copy$default(SeasonEpisodesResponse seasonEpisodesResponse, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = seasonEpisodesResponse.seasonId;
        }
        if ((i & 2) != 0) {
            list = seasonEpisodesResponse.episodes;
        }
        return seasonEpisodesResponse.copy(num, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getSeasonId() {
        return this.seasonId;
    }

    @Nullable
    public final List<EpisodeInfo> component2() {
        return this.episodes;
    }

    @NotNull
    public final SeasonEpisodesResponse copy(@JsonProperty("season_id") @Nullable Integer seasonId, @JsonProperty("episodes") @Nullable List<EpisodeInfo> episodes) {
        return new SeasonEpisodesResponse(seasonId, episodes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeasonEpisodesResponse)) {
            return false;
        }
        SeasonEpisodesResponse seasonEpisodesResponse = (SeasonEpisodesResponse) other;
        return Intrinsics.areEqual(this.seasonId, seasonEpisodesResponse.seasonId) && Intrinsics.areEqual(this.episodes, seasonEpisodesResponse.episodes);
    }

    public int hashCode() {
        return ((this.seasonId == null ? 0 : this.seasonId.hashCode()) * 31) + (this.episodes != null ? this.episodes.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SeasonEpisodesResponse(seasonId=" + this.seasonId + ", episodes=" + this.episodes + ')';
    }

    public SeasonEpisodesResponse(@JsonProperty("season_id") @Nullable Integer seasonId, @JsonProperty("episodes") @Nullable List<EpisodeInfo> list) {
        this.seasonId = seasonId;
        this.episodes = list;
    }

    public /* synthetic */ SeasonEpisodesResponse(Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : list);
    }

    @Nullable
    public final Integer getSeasonId() {
        return this.seasonId;
    }

    @Nullable
    public final List<EpisodeInfo> getEpisodes() {
        return this.episodes;
    }
}
