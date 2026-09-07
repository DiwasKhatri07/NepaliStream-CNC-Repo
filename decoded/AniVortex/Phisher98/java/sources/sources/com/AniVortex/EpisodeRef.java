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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJv\u0010\u0018\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR)\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR)\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fÊ\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0007\u0010\u0002¨\u0006 "}, d2 = {"Lcom/AniVortex/EpisodeRef;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "seasonId", "season_id", "seasonNumber", "season_number", "episodeNumber", "episode_number", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeasonId", "getSeasonNumber", "getEpisodeNumber", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/AniVortex/EpisodeRef;", "equals", "", "other", "hashCode", "toString", "", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeRef {

    @JsonProperty("episode_number")
    @Nullable
    private final Integer episodeNumber;

    @JsonProperty("id")
    @Nullable
    private final Integer id;

    @JsonProperty("season_id")
    @Nullable
    private final Integer seasonId;

    @JsonProperty("season_number")
    @Nullable
    private final Integer seasonNumber;

    public EpisodeRef() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ EpisodeRef copy$default(EpisodeRef episodeRef, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = episodeRef.id;
        }
        if ((i & 2) != 0) {
            num2 = episodeRef.seasonId;
        }
        if ((i & 4) != 0) {
            num3 = episodeRef.seasonNumber;
        }
        if ((i & 8) != 0) {
            num4 = episodeRef.episodeNumber;
        }
        return episodeRef.copy(num, num2, num3, num4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSeasonId() {
        return this.seasonId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    @NotNull
    public final EpisodeRef copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("season_id") @Nullable Integer seasonId, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("episode_number") @Nullable Integer episodeNumber) {
        return new EpisodeRef(id, seasonId, seasonNumber, episodeNumber);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeRef)) {
            return false;
        }
        EpisodeRef episodeRef = (EpisodeRef) other;
        return Intrinsics.areEqual(this.id, episodeRef.id) && Intrinsics.areEqual(this.seasonId, episodeRef.seasonId) && Intrinsics.areEqual(this.seasonNumber, episodeRef.seasonNumber) && Intrinsics.areEqual(this.episodeNumber, episodeRef.episodeNumber);
    }

    public int hashCode() {
        return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.seasonId == null ? 0 : this.seasonId.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.episodeNumber != null ? this.episodeNumber.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeRef(id=" + this.id + ", seasonId=" + this.seasonId + ", seasonNumber=" + this.seasonNumber + ", episodeNumber=" + this.episodeNumber + ')';
    }

    public EpisodeRef(@JsonProperty("id") @Nullable Integer id, @JsonProperty("season_id") @Nullable Integer seasonId, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("episode_number") @Nullable Integer episodeNumber) {
        this.id = id;
        this.seasonId = seasonId;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }

    public /* synthetic */ EpisodeRef(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final Integer getSeasonId() {
        return this.seasonId;
    }

    @Nullable
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }
}
