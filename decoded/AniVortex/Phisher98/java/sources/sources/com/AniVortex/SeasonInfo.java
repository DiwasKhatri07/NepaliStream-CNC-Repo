package com.AniVortex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexModels.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\\\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR)\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR)\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rÊ\u0001\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u001c"}, d2 = {"Lcom/AniVortex/SeasonInfo;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "seasonNumber", "season_number", "episodeCount", "episode_count", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeasonNumber", "getEpisodeCount", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/AniVortex/SeasonInfo;", "equals", "", "other", "hashCode", "toString", "", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SeasonInfo {

    @JsonProperty("episode_count")
    @Nullable
    private final Integer episodeCount;

    @JsonProperty("id")
    @Nullable
    private final Integer id;

    @JsonProperty("season_number")
    @Nullable
    private final Integer seasonNumber;

    public SeasonInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SeasonInfo copy$default(SeasonInfo seasonInfo, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = seasonInfo.id;
        }
        if ((i & 2) != 0) {
            num2 = seasonInfo.seasonNumber;
        }
        if ((i & 4) != 0) {
            num3 = seasonInfo.episodeCount;
        }
        return seasonInfo.copy(num, num2, num3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getEpisodeCount() {
        return this.episodeCount;
    }

    @NotNull
    public final SeasonInfo copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("episode_count") @Nullable Integer episodeCount) {
        return new SeasonInfo(id, seasonNumber, episodeCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeasonInfo)) {
            return false;
        }
        SeasonInfo seasonInfo = (SeasonInfo) other;
        return Intrinsics.areEqual(this.id, seasonInfo.id) && Intrinsics.areEqual(this.seasonNumber, seasonInfo.seasonNumber) && Intrinsics.areEqual(this.episodeCount, seasonInfo.episodeCount);
    }

    public int hashCode() {
        return ((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.episodeCount != null ? this.episodeCount.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SeasonInfo(id=" + this.id + ", seasonNumber=" + this.seasonNumber + ", episodeCount=" + this.episodeCount + ')';
    }

    public SeasonInfo(@JsonProperty("id") @Nullable Integer id, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("episode_count") @Nullable Integer episodeCount) {
        this.id = id;
        this.seasonNumber = seasonNumber;
        this.episodeCount = episodeCount;
    }

    public /* synthetic */ SeasonInfo(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    public final Integer getEpisodeCount() {
        return this.episodeCount;
    }
}
