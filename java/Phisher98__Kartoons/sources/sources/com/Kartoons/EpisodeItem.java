package com.Kartoons;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Kartoons/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0094\u0001\u0010.\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u000204HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b#\u0010\u0019¨\u00066"}, d2 = {"Lcom/Kartoons/EpisodeItem;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "_id", "seasonId", "episodeNumber", "", "title", "description", "image", "duration", "createdAt", "Lcom/Kartoons/EpisodeCreatedAt;", "updatedAt", "Lcom/Kartoons/EpisodeUpdatedAt;", "durationMinutes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/Kartoons/EpisodeCreatedAt;Lcom/Kartoons/EpisodeUpdatedAt;Ljava/lang/Long;)V", "getId", "()Ljava/lang/String;", "getSeasonId", "getEpisodeNumber", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "getDescription", "getImage", "getDuration", "getCreatedAt", "()Lcom/Kartoons/EpisodeCreatedAt;", "getUpdatedAt", "()Lcom/Kartoons/EpisodeUpdatedAt;", "getDurationMinutes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/Kartoons/EpisodeCreatedAt;Lcom/Kartoons/EpisodeUpdatedAt;Ljava/lang/Long;)Lcom/Kartoons/EpisodeItem;", "equals", "", "other", "hashCode", "", "toString", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeItem {

    @Nullable
    private final EpisodeCreatedAt createdAt;

    @Nullable
    private final String description;

    @Nullable
    private final String duration;

    @Nullable
    private final Long durationMinutes;

    @Nullable
    private final Long episodeNumber;

    @JsonProperty("_id")
    @Nullable
    private final String id;

    @Nullable
    private final String image;

    @Nullable
    private final String seasonId;

    @Nullable
    private final String title;

    @Nullable
    private final EpisodeUpdatedAt updatedAt;

    public EpisodeItem() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ EpisodeItem copy$default(EpisodeItem episodeItem, String str, String str2, Long l, String str3, String str4, String str5, String str6, EpisodeCreatedAt episodeCreatedAt, EpisodeUpdatedAt episodeUpdatedAt, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episodeItem.id;
        }
        if ((i & 2) != 0) {
            str2 = episodeItem.seasonId;
        }
        if ((i & 4) != 0) {
            l = episodeItem.episodeNumber;
        }
        if ((i & 8) != 0) {
            str3 = episodeItem.title;
        }
        if ((i & 16) != 0) {
            str4 = episodeItem.description;
        }
        if ((i & 32) != 0) {
            str5 = episodeItem.image;
        }
        if ((i & 64) != 0) {
            str6 = episodeItem.duration;
        }
        if ((i & 128) != 0) {
            episodeCreatedAt = episodeItem.createdAt;
        }
        if ((i & 256) != 0) {
            episodeUpdatedAt = episodeItem.updatedAt;
        }
        if ((i & 512) != 0) {
            l2 = episodeItem.durationMinutes;
        }
        EpisodeUpdatedAt episodeUpdatedAt2 = episodeUpdatedAt;
        Long l3 = l2;
        String str7 = str6;
        EpisodeCreatedAt episodeCreatedAt2 = episodeCreatedAt;
        String str8 = str4;
        String str9 = str5;
        return episodeItem.copy(str, str2, l, str3, str8, str9, str7, episodeCreatedAt2, episodeUpdatedAt2, l3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getDurationMinutes() {
        return this.durationMinutes;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSeasonId() {
        return this.seasonId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getEpisodeNumber() {
        return this.episodeNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final EpisodeCreatedAt getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final EpisodeUpdatedAt getUpdatedAt() {
        return this.updatedAt;
    }

    @NotNull
    public final EpisodeItem copy(@JsonProperty("_id") @Nullable String id, @Nullable String seasonId, @Nullable Long episodeNumber, @Nullable String title, @Nullable String description, @Nullable String image, @Nullable String duration, @Nullable EpisodeCreatedAt createdAt, @Nullable EpisodeUpdatedAt updatedAt, @Nullable Long durationMinutes) {
        return new EpisodeItem(id, seasonId, episodeNumber, title, description, image, duration, createdAt, updatedAt, durationMinutes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeItem)) {
            return false;
        }
        EpisodeItem episodeItem = (EpisodeItem) other;
        return Intrinsics.areEqual(this.id, episodeItem.id) && Intrinsics.areEqual(this.seasonId, episodeItem.seasonId) && Intrinsics.areEqual(this.episodeNumber, episodeItem.episodeNumber) && Intrinsics.areEqual(this.title, episodeItem.title) && Intrinsics.areEqual(this.description, episodeItem.description) && Intrinsics.areEqual(this.image, episodeItem.image) && Intrinsics.areEqual(this.duration, episodeItem.duration) && Intrinsics.areEqual(this.createdAt, episodeItem.createdAt) && Intrinsics.areEqual(this.updatedAt, episodeItem.updatedAt) && Intrinsics.areEqual(this.durationMinutes, episodeItem.durationMinutes);
    }

    public int hashCode() {
        return ((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.seasonId == null ? 0 : this.seasonId.hashCode())) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt == null ? 0 : this.updatedAt.hashCode())) * 31) + (this.durationMinutes != null ? this.durationMinutes.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeItem(id=" + this.id + ", seasonId=" + this.seasonId + ", episodeNumber=" + this.episodeNumber + ", title=" + this.title + ", description=" + this.description + ", image=" + this.image + ", duration=" + this.duration + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", durationMinutes=" + this.durationMinutes + ')';
    }

    public EpisodeItem(@JsonProperty("_id") @Nullable String id, @Nullable String seasonId, @Nullable Long episodeNumber, @Nullable String title, @Nullable String description, @Nullable String image, @Nullable String duration, @Nullable EpisodeCreatedAt createdAt, @Nullable EpisodeUpdatedAt updatedAt, @Nullable Long durationMinutes) {
        this.id = id;
        this.seasonId = seasonId;
        this.episodeNumber = episodeNumber;
        this.title = title;
        this.description = description;
        this.image = image;
        this.duration = duration;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.durationMinutes = durationMinutes;
    }

    public /* synthetic */ EpisodeItem(String str, String str2, Long l, String str3, String str4, String str5, String str6, EpisodeCreatedAt episodeCreatedAt, EpisodeUpdatedAt episodeUpdatedAt, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : episodeCreatedAt, (i & 256) != 0 ? null : episodeUpdatedAt, (i & 512) != 0 ? null : l2);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getSeasonId() {
        return this.seasonId;
    }

    @Nullable
    public final Long getEpisodeNumber() {
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
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getDuration() {
        return this.duration;
    }

    @Nullable
    public final EpisodeCreatedAt getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final EpisodeUpdatedAt getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    public final Long getDurationMinutes() {
        return this.durationMinutes;
    }
}
