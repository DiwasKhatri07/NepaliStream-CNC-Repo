package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jª\u0001\u0010 \u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006'"}, d2 = {"Lcom/phisher98/Media;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "title", "originalTitle", "original_title", "mediaType", "media_type", "posterPath", "poster_path", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getTitle", "getOriginalTitle", "getMediaType", "getPosterPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/Media;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    public Media() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Media copy$default(Media media, Integer num, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
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
        String str6 = str4;
        String str7 = str5;
        return media.copy(num, str, str2, str3, str6, str7);
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

    @NotNull
    public final Media copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("poster_path") @Nullable String posterPath) {
        return new Media(id, name, title, originalTitle, mediaType, posterPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Media)) {
            return false;
        }
        Media media = (Media) other;
        return Intrinsics.areEqual(this.id, media.id) && Intrinsics.areEqual(this.name, media.name) && Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.originalTitle, media.originalTitle) && Intrinsics.areEqual(this.mediaType, media.mediaType) && Intrinsics.areEqual(this.posterPath, media.posterPath);
    }

    public int hashCode() {
        return ((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.mediaType == null ? 0 : this.mediaType.hashCode())) * 31) + (this.posterPath != null ? this.posterPath.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Media(id=" + this.id + ", name=" + this.name + ", title=" + this.title + ", originalTitle=" + this.originalTitle + ", mediaType=" + this.mediaType + ", posterPath=" + this.posterPath + ')';
    }

    public Media(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("poster_path") @Nullable String posterPath) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.originalTitle = originalTitle;
        this.mediaType = mediaType;
        this.posterPath = posterPath;
    }

    public /* synthetic */ Media(Integer num, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
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
}
