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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\rHÆ\u0003Jø\u0001\u0010,\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014HÆ\u0001¢\u0006\u0002\u0010-J\u0014\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00102\u001a\u00020\rHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R)\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R)\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R)\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R'\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR'\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR'\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR)\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0018R'\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eÊ\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0007\u0010\u0002¨\u00063"}, d2 = {"Lcom/AniVortex/EpisodeInfo;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "seasonId", "season_id", "seasonNumber", "season_number", "episodeNumber", "episode_number", "title", "", "description", "thumbnailUrl", "thumbnail_url", "durationSeconds", "duration_seconds", "releaseDate", "release_date", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeasonId", "getSeasonNumber", "getEpisodeNumber", "getTitle", "()Ljava/lang/String;", "getDescription", "getThumbnailUrl", "getDurationSeconds", "getReleaseDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/AniVortex/EpisodeInfo;", "equals", "", "other", "hashCode", "toString", "AniVortex", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeInfo {

    @JsonProperty("description")
    @Nullable
    private final String description;

    @JsonProperty("duration_seconds")
    @Nullable
    private final Integer durationSeconds;

    @JsonProperty("episode_number")
    @Nullable
    private final Integer episodeNumber;

    @JsonProperty("id")
    @Nullable
    private final Integer id;

    @JsonProperty("release_date")
    @Nullable
    private final String releaseDate;

    @JsonProperty("season_id")
    @Nullable
    private final Integer seasonId;

    @JsonProperty("season_number")
    @Nullable
    private final Integer seasonNumber;

    @JsonProperty("thumbnail_url")
    @Nullable
    private final String thumbnailUrl;

    @JsonProperty("title")
    @Nullable
    private final String title;

    public EpisodeInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ EpisodeInfo copy$default(EpisodeInfo episodeInfo, Integer num, Integer num2, Integer num3, Integer num4, String str, String str2, String str3, Integer num5, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = episodeInfo.id;
        }
        if ((i & 2) != 0) {
            num2 = episodeInfo.seasonId;
        }
        if ((i & 4) != 0) {
            num3 = episodeInfo.seasonNumber;
        }
        if ((i & 8) != 0) {
            num4 = episodeInfo.episodeNumber;
        }
        if ((i & 16) != 0) {
            str = episodeInfo.title;
        }
        if ((i & 32) != 0) {
            str2 = episodeInfo.description;
        }
        if ((i & 64) != 0) {
            str3 = episodeInfo.thumbnailUrl;
        }
        if ((i & 128) != 0) {
            num5 = episodeInfo.durationSeconds;
        }
        if ((i & 256) != 0) {
            str4 = episodeInfo.releaseDate;
        }
        Integer num6 = num5;
        String str5 = str4;
        String str6 = str2;
        String str7 = str3;
        String str8 = str;
        Integer num7 = num3;
        return episodeInfo.copy(num, num2, num7, num4, str8, str6, str7, num6, str5);
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

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @NotNull
    public final EpisodeInfo copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("season_id") @Nullable Integer seasonId, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("title") @Nullable String title, @JsonProperty("description") @Nullable String description, @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl, @JsonProperty("duration_seconds") @Nullable Integer durationSeconds, @JsonProperty("release_date") @Nullable String releaseDate) {
        return new EpisodeInfo(id, seasonId, seasonNumber, episodeNumber, title, description, thumbnailUrl, durationSeconds, releaseDate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeInfo)) {
            return false;
        }
        EpisodeInfo episodeInfo = (EpisodeInfo) other;
        return Intrinsics.areEqual(this.id, episodeInfo.id) && Intrinsics.areEqual(this.seasonId, episodeInfo.seasonId) && Intrinsics.areEqual(this.seasonNumber, episodeInfo.seasonNumber) && Intrinsics.areEqual(this.episodeNumber, episodeInfo.episodeNumber) && Intrinsics.areEqual(this.title, episodeInfo.title) && Intrinsics.areEqual(this.description, episodeInfo.description) && Intrinsics.areEqual(this.thumbnailUrl, episodeInfo.thumbnailUrl) && Intrinsics.areEqual(this.durationSeconds, episodeInfo.durationSeconds) && Intrinsics.areEqual(this.releaseDate, episodeInfo.releaseDate);
    }

    public int hashCode() {
        return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.seasonId == null ? 0 : this.seasonId.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.thumbnailUrl == null ? 0 : this.thumbnailUrl.hashCode())) * 31) + (this.durationSeconds == null ? 0 : this.durationSeconds.hashCode())) * 31) + (this.releaseDate != null ? this.releaseDate.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeInfo(id=" + this.id + ", seasonId=" + this.seasonId + ", seasonNumber=" + this.seasonNumber + ", episodeNumber=" + this.episodeNumber + ", title=" + this.title + ", description=" + this.description + ", thumbnailUrl=" + this.thumbnailUrl + ", durationSeconds=" + this.durationSeconds + ", releaseDate=" + this.releaseDate + ')';
    }

    public EpisodeInfo(@JsonProperty("id") @Nullable Integer id, @JsonProperty("season_id") @Nullable Integer seasonId, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("title") @Nullable String title, @JsonProperty("description") @Nullable String description, @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl, @JsonProperty("duration_seconds") @Nullable Integer durationSeconds, @JsonProperty("release_date") @Nullable String releaseDate) {
        this.id = id;
        this.seasonId = seasonId;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.durationSeconds = durationSeconds;
        this.releaseDate = releaseDate;
    }

    public /* synthetic */ EpisodeInfo(Integer num, Integer num2, Integer num3, Integer num4, String str, String str2, String str3, Integer num5, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : num5, (i & 256) != 0 ? null : str4);
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

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    @Nullable
    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    @Nullable
    public final String getReleaseDate() {
        return this.releaseDate;
    }
}
