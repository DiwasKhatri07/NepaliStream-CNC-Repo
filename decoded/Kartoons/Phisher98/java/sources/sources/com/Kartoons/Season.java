package com.Kartoons;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0088\u0001\u0010+\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u000201HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0017¨\u00063"}, d2 = {"Lcom/Kartoons/Season;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_id", "seasonNumber", "", "title", "releaseYear", "showId", "createdAt", "Lcom/Kartoons/CreatedAt2;", "updatedAt", "Lcom/Kartoons/UpdatedAt2;", "slug", "episodeCount", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/Kartoons/CreatedAt2;Lcom/Kartoons/UpdatedAt2;Ljava/lang/String;Ljava/lang/Long;)V", "getId", "()Ljava/lang/String;", "getSeasonNumber", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "getReleaseYear", "getShowId", "getCreatedAt", "()Lcom/Kartoons/CreatedAt2;", "getUpdatedAt", "()Lcom/Kartoons/UpdatedAt2;", "getSlug", "getEpisodeCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/Kartoons/CreatedAt2;Lcom/Kartoons/UpdatedAt2;Ljava/lang/String;Ljava/lang/Long;)Lcom/Kartoons/Season;", "equals", "", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Season {

    @Nullable
    private final CreatedAt2 createdAt;

    @Nullable
    private final Long episodeCount;

    @JsonProperty("_id")
    @Nullable
    private final String id;

    @Nullable
    private final Long releaseYear;

    @Nullable
    private final Long seasonNumber;

    @Nullable
    private final String showId;

    @Nullable
    private final String slug;

    @Nullable
    private final String title;

    @Nullable
    private final UpdatedAt2 updatedAt;

    public Season() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ Season copy$default(Season season, String str, Long l, String str2, Long l2, String str3, CreatedAt2 createdAt2, UpdatedAt2 updatedAt2, String str4, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = season.id;
        }
        if ((i & 2) != 0) {
            l = season.seasonNumber;
        }
        if ((i & 4) != 0) {
            str2 = season.title;
        }
        if ((i & 8) != 0) {
            l2 = season.releaseYear;
        }
        if ((i & 16) != 0) {
            str3 = season.showId;
        }
        if ((i & 32) != 0) {
            createdAt2 = season.createdAt;
        }
        if ((i & 64) != 0) {
            updatedAt2 = season.updatedAt;
        }
        if ((i & 128) != 0) {
            str4 = season.slug;
        }
        if ((i & 256) != 0) {
            l3 = season.episodeCount;
        }
        String str5 = str4;
        Long l4 = l3;
        CreatedAt2 createdAt3 = createdAt2;
        UpdatedAt2 updatedAt3 = updatedAt2;
        String str6 = str3;
        String str7 = str2;
        return season.copy(str, l, str7, l2, str6, createdAt3, updatedAt3, str5, l4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getReleaseYear() {
        return this.releaseYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getShowId() {
        return this.showId;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CreatedAt2 getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UpdatedAt2 getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getEpisodeCount() {
        return this.episodeCount;
    }

    @NotNull
    public final Season copy(@JsonProperty("_id") @Nullable String id, @Nullable Long seasonNumber, @Nullable String title, @Nullable Long releaseYear, @Nullable String showId, @Nullable CreatedAt2 createdAt, @Nullable UpdatedAt2 updatedAt, @Nullable String slug, @Nullable Long episodeCount) {
        return new Season(id, seasonNumber, title, releaseYear, showId, createdAt, updatedAt, slug, episodeCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Season)) {
            return false;
        }
        Season season = (Season) other;
        return Intrinsics.areEqual(this.id, season.id) && Intrinsics.areEqual(this.seasonNumber, season.seasonNumber) && Intrinsics.areEqual(this.title, season.title) && Intrinsics.areEqual(this.releaseYear, season.releaseYear) && Intrinsics.areEqual(this.showId, season.showId) && Intrinsics.areEqual(this.createdAt, season.createdAt) && Intrinsics.areEqual(this.updatedAt, season.updatedAt) && Intrinsics.areEqual(this.slug, season.slug) && Intrinsics.areEqual(this.episodeCount, season.episodeCount);
    }

    public int hashCode() {
        return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.releaseYear == null ? 0 : this.releaseYear.hashCode())) * 31) + (this.showId == null ? 0 : this.showId.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt == null ? 0 : this.updatedAt.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.episodeCount != null ? this.episodeCount.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Season(id=" + this.id + ", seasonNumber=" + this.seasonNumber + ", title=" + this.title + ", releaseYear=" + this.releaseYear + ", showId=" + this.showId + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", slug=" + this.slug + ", episodeCount=" + this.episodeCount + ')';
    }

    public Season(@JsonProperty("_id") @Nullable String id, @Nullable Long seasonNumber, @Nullable String title, @Nullable Long releaseYear, @Nullable String showId, @Nullable CreatedAt2 createdAt, @Nullable UpdatedAt2 updatedAt, @Nullable String slug, @Nullable Long episodeCount) {
        this.id = id;
        this.seasonNumber = seasonNumber;
        this.title = title;
        this.releaseYear = releaseYear;
        this.showId = showId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.slug = slug;
        this.episodeCount = episodeCount;
    }

    public /* synthetic */ Season(String str, Long l, String str2, Long l2, String str3, CreatedAt2 createdAt2, UpdatedAt2 updatedAt2, String str4, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : createdAt2, (i & 64) != 0 ? null : updatedAt2, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : l3);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Long getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Long getReleaseYear() {
        return this.releaseYear;
    }

    @Nullable
    public final String getShowId() {
        return this.showId;
    }

    @Nullable
    public final CreatedAt2 getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final UpdatedAt2 getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final Long getEpisodeCount() {
        return this.episodeCount;
    }
}
