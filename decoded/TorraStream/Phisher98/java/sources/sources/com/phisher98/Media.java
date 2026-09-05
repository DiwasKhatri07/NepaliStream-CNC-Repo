package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B½\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001eJÄ\u0001\u0010'\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011HÆ\u0001¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/phisher98/Media;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "title", "originalTitle", "original_title", "mediaType", "media_type", "posterPath", "poster_path", "voteAverage", "", "vote_average", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getTitle", "getOriginalTitle", "getMediaType", "getPosterPath", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/phisher98/Media;", "equals", "", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Media {

    @Nullable
    private final Integer id;

    @Nullable
    private final String mediaType;

    @Nullable
    private final String name;

    @Nullable
    private final String originalTitle;

    @Nullable
    private final String posterPath;

    @Nullable
    private final String title;

    @Nullable
    private final Double voteAverage;

    public Media() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ Media copy$default(Media media, Integer num, String str, String str2, String str3, String str4, String str5, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            num = media.id;
        }
        if ((i & 2) != 0) {
            str = media.name;
        }
        if ((i & 4) != 0) {
            str2 = media.title;
        }
        if ((i & 8) != 0) {
            str3 = media.originalTitle;
        }
        if ((i & 16) != 0) {
            str4 = media.mediaType;
        }
        if ((i & 32) != 0) {
            str5 = media.posterPath;
        }
        if ((i & 64) != 0) {
            d = media.voteAverage;
        }
        String str6 = str5;
        Double d2 = d;
        String str7 = str4;
        String str8 = str2;
        return media.copy(num, str, str8, str3, str7, str6, d2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMediaType() {
        return this.mediaType;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getVoteAverage() {
        return this.voteAverage;
    }

    @NotNull
    public final Media copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("vote_average") @Nullable Double voteAverage) {
        return new Media(id, name, title, originalTitle, mediaType, posterPath, voteAverage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Media)) {
            return false;
        }
        Media media = (Media) other;
        return Intrinsics.areEqual(this.id, media.id) && Intrinsics.areEqual(this.name, media.name) && Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.originalTitle, media.originalTitle) && Intrinsics.areEqual(this.mediaType, media.mediaType) && Intrinsics.areEqual(this.posterPath, media.posterPath) && Intrinsics.areEqual(this.voteAverage, media.voteAverage);
    }

    public int hashCode() {
        return ((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.mediaType == null ? 0 : this.mediaType.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.voteAverage != null ? this.voteAverage.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Media(id=" + this.id + ", name=" + this.name + ", title=" + this.title + ", originalTitle=" + this.originalTitle + ", mediaType=" + this.mediaType + ", posterPath=" + this.posterPath + ", voteAverage=" + this.voteAverage + ')';
    }

    public Media(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("vote_average") @Nullable Double voteAverage) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.originalTitle = originalTitle;
        this.mediaType = mediaType;
        this.posterPath = posterPath;
        this.voteAverage = voteAverage;
    }

    public /* synthetic */ Media(Integer num, String str, String str2, String str3, String str4, String str5, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : d);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getOriginalTitle() {
        return this.originalTitle;
    }

    @Nullable
    public final String getMediaType() {
        return this.mediaType;
    }

    @Nullable
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    public final Double getVoteAverage() {
        return this.voteAverage;
    }
}
