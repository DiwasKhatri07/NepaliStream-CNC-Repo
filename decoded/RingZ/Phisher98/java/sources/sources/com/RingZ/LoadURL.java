package com.RingZ;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RingZParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/RingZ/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020,HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006."}, d2 = {"Lcom/RingZ/LoadURL;", "", "url", "", "title", "id", "posterUrl", "trailer", "quality", "language", "type", "category", "genre", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getTitle", "getId", "getPosterUrl", "getTrailer", "getQuality", "getLanguage", "getType", "getCategory", "getGenre", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "RingZ"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadURL {

    @Nullable
    private final String category;

    @Nullable
    private final String extra;

    @Nullable
    private final String genre;

    @Nullable
    private final String id;

    @Nullable
    private final String language;

    @Nullable
    private final String posterUrl;

    @Nullable
    private final String quality;

    @Nullable
    private final String title;

    @Nullable
    private final String trailer;

    @Nullable
    private final String type;

    @Nullable
    private final String url;

    public LoadURL() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ LoadURL copy$default(LoadURL loadURL, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadURL.url;
        }
        if ((i & 2) != 0) {
            str2 = loadURL.title;
        }
        if ((i & 4) != 0) {
            str3 = loadURL.id;
        }
        if ((i & 8) != 0) {
            str4 = loadURL.posterUrl;
        }
        if ((i & 16) != 0) {
            str5 = loadURL.trailer;
        }
        if ((i & 32) != 0) {
            str6 = loadURL.quality;
        }
        if ((i & 64) != 0) {
            str7 = loadURL.language;
        }
        if ((i & 128) != 0) {
            str8 = loadURL.type;
        }
        if ((i & 256) != 0) {
            str9 = loadURL.category;
        }
        if ((i & 512) != 0) {
            str10 = loadURL.genre;
        }
        if ((i & 1024) != 0) {
            str11 = loadURL.extra;
        }
        String str12 = str10;
        String str13 = str11;
        String str14 = str8;
        String str15 = str9;
        String str16 = str6;
        String str17 = str7;
        String str18 = str5;
        String str19 = str3;
        return loadURL.copy(str, str2, str19, str4, str18, str16, str17, str14, str15, str12, str13);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getGenre() {
        return this.genre;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTrailer() {
        return this.trailer;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final LoadURL copy(@Nullable String url, @Nullable String title, @Nullable String id, @Nullable String posterUrl, @Nullable String trailer, @Nullable String quality, @Nullable String language, @Nullable String type, @Nullable String category, @Nullable String genre, @Nullable String extra) {
        return new LoadURL(url, title, id, posterUrl, trailer, quality, language, type, category, genre, extra);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadURL)) {
            return false;
        }
        LoadURL loadURL = (LoadURL) other;
        return Intrinsics.areEqual(this.url, loadURL.url) && Intrinsics.areEqual(this.title, loadURL.title) && Intrinsics.areEqual(this.id, loadURL.id) && Intrinsics.areEqual(this.posterUrl, loadURL.posterUrl) && Intrinsics.areEqual(this.trailer, loadURL.trailer) && Intrinsics.areEqual(this.quality, loadURL.quality) && Intrinsics.areEqual(this.language, loadURL.language) && Intrinsics.areEqual(this.type, loadURL.type) && Intrinsics.areEqual(this.category, loadURL.category) && Intrinsics.areEqual(this.genre, loadURL.genre) && Intrinsics.areEqual(this.extra, loadURL.extra);
    }

    public int hashCode() {
        return ((((((((((((((((((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.posterUrl == null ? 0 : this.posterUrl.hashCode())) * 31) + (this.trailer == null ? 0 : this.trailer.hashCode())) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.language == null ? 0 : this.language.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.category == null ? 0 : this.category.hashCode())) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + (this.extra != null ? this.extra.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadURL(url=").append(this.url).append(", title=").append(this.title).append(", id=").append(this.id).append(", posterUrl=").append(this.posterUrl).append(", trailer=").append(this.trailer).append(", quality=").append(this.quality).append(", language=").append(this.language).append(", type=").append(this.type).append(", category=").append(this.category).append(", genre=").append(this.genre).append(", extra=").append(this.extra).append(')');
        return sb.toString();
    }

    public LoadURL(@Nullable String url, @Nullable String title, @Nullable String id, @Nullable String posterUrl, @Nullable String trailer, @Nullable String quality, @Nullable String language, @Nullable String type, @Nullable String category, @Nullable String genre, @Nullable String extra) {
        this.url = url;
        this.title = title;
        this.id = id;
        this.posterUrl = posterUrl;
        this.trailer = trailer;
        this.quality = quality;
        this.language = language;
        this.type = type;
        this.category = category;
        this.genre = genre;
        this.extra = extra;
    }

    public /* synthetic */ LoadURL(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11);
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getPosterUrl() {
        return this.posterUrl;
    }

    @Nullable
    public final String getTrailer() {
        return this.trailer;
    }

    @Nullable
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getGenre() {
        return this.genre;
    }

    @Nullable
    public final String getExtra() {
        return this.extra;
    }
}
