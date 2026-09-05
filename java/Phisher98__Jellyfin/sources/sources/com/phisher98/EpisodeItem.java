package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JellyfinParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Jellyfin/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u008c\u0001\u0010!\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010HÆ\u0001¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\nHÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/phisher98/EpisodeItem;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Id", "name", "Name", "indexNumber", "", "IndexNumber", "seasonName", "SeasonName", "imageTags", "Lcom/phisher98/EpisodeImageTags;", "ImageTags", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/EpisodeImageTags;)V", "getId", "()Ljava/lang/String;", "getName", "getIndexNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeasonName", "getImageTags", "()Lcom/phisher98/EpisodeImageTags;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/EpisodeImageTags;)Lcom/phisher98/EpisodeItem;", "equals", "", "other", "hashCode", "toString", "Jellyfin"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeItem {

    @NotNull
    private final String id;

    @Nullable
    private final EpisodeImageTags imageTags;

    @Nullable
    private final Integer indexNumber;

    @NotNull
    private final String name;

    @Nullable
    private final String seasonName;

    public static /* synthetic */ EpisodeItem copy$default(EpisodeItem episodeItem, String str, String str2, Integer num, String str3, EpisodeImageTags episodeImageTags, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episodeItem.id;
        }
        if ((i & 2) != 0) {
            str2 = episodeItem.name;
        }
        if ((i & 4) != 0) {
            num = episodeItem.indexNumber;
        }
        if ((i & 8) != 0) {
            str3 = episodeItem.seasonName;
        }
        if ((i & 16) != 0) {
            episodeImageTags = episodeItem.imageTags;
        }
        EpisodeImageTags episodeImageTags2 = episodeImageTags;
        Integer num2 = num;
        return episodeItem.copy(str, str2, num2, str3, episodeImageTags2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getIndexNumber() {
        return this.indexNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSeasonName() {
        return this.seasonName;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final EpisodeImageTags getImageTags() {
        return this.imageTags;
    }

    @NotNull
    public final EpisodeItem copy(@JsonProperty("Id") @NotNull String id, @JsonProperty("Name") @NotNull String name, @JsonProperty("IndexNumber") @Nullable Integer indexNumber, @JsonProperty("SeasonName") @Nullable String seasonName, @JsonProperty("ImageTags") @Nullable EpisodeImageTags imageTags) {
        return new EpisodeItem(id, name, indexNumber, seasonName, imageTags);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeItem)) {
            return false;
        }
        EpisodeItem episodeItem = (EpisodeItem) other;
        return Intrinsics.areEqual(this.id, episodeItem.id) && Intrinsics.areEqual(this.name, episodeItem.name) && Intrinsics.areEqual(this.indexNumber, episodeItem.indexNumber) && Intrinsics.areEqual(this.seasonName, episodeItem.seasonName) && Intrinsics.areEqual(this.imageTags, episodeItem.imageTags);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + (this.indexNumber == null ? 0 : this.indexNumber.hashCode())) * 31) + (this.seasonName == null ? 0 : this.seasonName.hashCode())) * 31) + (this.imageTags != null ? this.imageTags.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeItem(id=" + this.id + ", name=" + this.name + ", indexNumber=" + this.indexNumber + ", seasonName=" + this.seasonName + ", imageTags=" + this.imageTags + ')';
    }

    public EpisodeItem(@JsonProperty("Id") @NotNull String id, @JsonProperty("Name") @NotNull String name, @JsonProperty("IndexNumber") @Nullable Integer indexNumber, @JsonProperty("SeasonName") @Nullable String seasonName, @JsonProperty("ImageTags") @Nullable EpisodeImageTags imageTags) {
        this.id = id;
        this.name = name;
        this.indexNumber = indexNumber;
        this.seasonName = seasonName;
        this.imageTags = imageTags;
    }

    public /* synthetic */ EpisodeItem(String str, String str2, Integer num, String str3, EpisodeImageTags episodeImageTags, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : episodeImageTags);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer getIndexNumber() {
        return this.indexNumber;
    }

    @Nullable
    public final String getSeasonName() {
        return this.seasonName;
    }

    @Nullable
    public final EpisodeImageTags getImageTags() {
        return this.imageTags;
    }
}
