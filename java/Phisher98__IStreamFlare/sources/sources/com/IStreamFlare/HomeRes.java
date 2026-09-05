package com.IStreamFlare;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IStreamFlare/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÅ\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010<\u001a\u00020=HÖ\u0081\u0004J\n\u0010>\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006?"}, d2 = {"Lcom/IStreamFlare/HomeRes;", "", "TMDB_ID", "", "banner", "content_type", "custom_tag", "Lcom/IStreamFlare/CustomTag;", "description", "downloadable", "genres", "id", "name", "poster", "release_date", "runtime", "status", "type", "youtube_trailer", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/IStreamFlare/CustomTag;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTMDB_ID", "()Ljava/lang/String;", "getBanner", "getContent_type", "getCustom_tag", "()Lcom/IStreamFlare/CustomTag;", "getDescription", "getDownloadable", "getGenres", "getId", "getName", "getPoster", "getRelease_date", "getRuntime", "getStatus", "getType", "getYoutube_trailer", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "hashCode", "", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HomeRes {

    @Nullable
    private final String TMDB_ID;

    @Nullable
    private final String banner;

    @Nullable
    private final String content_type;

    @Nullable
    private final CustomTag custom_tag;

    @Nullable
    private final String description;

    @Nullable
    private final String downloadable;

    @Nullable
    private final String genres;

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @Nullable
    private final String poster;

    @Nullable
    private final String release_date;

    @Nullable
    private final String runtime;

    @Nullable
    private final String status;

    @Nullable
    private final String type;

    @Nullable
    private final String url;

    @Nullable
    private final String youtube_trailer;

    public HomeRes() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public static /* synthetic */ HomeRes copy$default(HomeRes homeRes, String str, String str2, String str3, CustomTag customTag, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, Object obj) {
        String str16 = (i & 1) != 0 ? homeRes.TMDB_ID : str;
        return homeRes.copy(str16, (i & 2) != 0 ? homeRes.banner : str2, (i & 4) != 0 ? homeRes.content_type : str3, (i & 8) != 0 ? homeRes.custom_tag : customTag, (i & 16) != 0 ? homeRes.description : str4, (i & 32) != 0 ? homeRes.downloadable : str5, (i & 64) != 0 ? homeRes.genres : str6, (i & 128) != 0 ? homeRes.id : str7, (i & 256) != 0 ? homeRes.name : str8, (i & 512) != 0 ? homeRes.poster : str9, (i & 1024) != 0 ? homeRes.release_date : str10, (i & 2048) != 0 ? homeRes.runtime : str11, (i & 4096) != 0 ? homeRes.status : str12, (i & 8192) != 0 ? homeRes.type : str13, (i & 16384) != 0 ? homeRes.youtube_trailer : str14, (i & 32768) != 0 ? homeRes.url : str15);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTMDB_ID() {
        return this.TMDB_ID;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getRelease_date() {
        return this.release_date;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getRuntime() {
        return this.runtime;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getYoutube_trailer() {
        return this.youtube_trailer;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent_type() {
        return this.content_type;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CustomTag getCustom_tag() {
        return this.custom_tag;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDownloadable() {
        return this.downloadable;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getGenres() {
        return this.genres;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final HomeRes copy(@Nullable String TMDB_ID, @Nullable String banner, @Nullable String content_type, @Nullable CustomTag custom_tag, @Nullable String description, @Nullable String downloadable, @Nullable String genres, @NotNull String id, @NotNull String name, @Nullable String poster, @Nullable String release_date, @Nullable String runtime, @Nullable String status, @Nullable String type, @Nullable String youtube_trailer, @Nullable String url) {
        return new HomeRes(TMDB_ID, banner, content_type, custom_tag, description, downloadable, genres, id, name, poster, release_date, runtime, status, type, youtube_trailer, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeRes)) {
            return false;
        }
        HomeRes homeRes = (HomeRes) other;
        return Intrinsics.areEqual(this.TMDB_ID, homeRes.TMDB_ID) && Intrinsics.areEqual(this.banner, homeRes.banner) && Intrinsics.areEqual(this.content_type, homeRes.content_type) && Intrinsics.areEqual(this.custom_tag, homeRes.custom_tag) && Intrinsics.areEqual(this.description, homeRes.description) && Intrinsics.areEqual(this.downloadable, homeRes.downloadable) && Intrinsics.areEqual(this.genres, homeRes.genres) && Intrinsics.areEqual(this.id, homeRes.id) && Intrinsics.areEqual(this.name, homeRes.name) && Intrinsics.areEqual(this.poster, homeRes.poster) && Intrinsics.areEqual(this.release_date, homeRes.release_date) && Intrinsics.areEqual(this.runtime, homeRes.runtime) && Intrinsics.areEqual(this.status, homeRes.status) && Intrinsics.areEqual(this.type, homeRes.type) && Intrinsics.areEqual(this.youtube_trailer, homeRes.youtube_trailer) && Intrinsics.areEqual(this.url, homeRes.url);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((this.TMDB_ID == null ? 0 : this.TMDB_ID.hashCode()) * 31) + (this.banner == null ? 0 : this.banner.hashCode())) * 31) + (this.content_type == null ? 0 : this.content_type.hashCode())) * 31) + (this.custom_tag == null ? 0 : this.custom_tag.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.downloadable == null ? 0 : this.downloadable.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.release_date == null ? 0 : this.release_date.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.youtube_trailer == null ? 0 : this.youtube_trailer.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HomeRes(TMDB_ID=").append(this.TMDB_ID).append(", banner=").append(this.banner).append(", content_type=").append(this.content_type).append(", custom_tag=").append(this.custom_tag).append(", description=").append(this.description).append(", downloadable=").append(this.downloadable).append(", genres=").append(this.genres).append(", id=").append(this.id).append(", name=").append(this.name).append(", poster=").append(this.poster).append(", release_date=").append(this.release_date).append(", runtime=");
        sb.append(this.runtime).append(", status=").append(this.status).append(", type=").append(this.type).append(", youtube_trailer=").append(this.youtube_trailer).append(", url=").append(this.url).append(')');
        return sb.toString();
    }

    public HomeRes(@Nullable String TMDB_ID, @Nullable String banner, @Nullable String content_type, @Nullable CustomTag custom_tag, @Nullable String description, @Nullable String downloadable, @Nullable String genres, @NotNull String id, @NotNull String name, @Nullable String poster, @Nullable String release_date, @Nullable String runtime, @Nullable String status, @Nullable String type, @Nullable String youtube_trailer, @Nullable String url) {
        this.TMDB_ID = TMDB_ID;
        this.banner = banner;
        this.content_type = content_type;
        this.custom_tag = custom_tag;
        this.description = description;
        this.downloadable = downloadable;
        this.genres = genres;
        this.id = id;
        this.name = name;
        this.poster = poster;
        this.release_date = release_date;
        this.runtime = runtime;
        this.status = status;
        this.type = type;
        this.youtube_trailer = youtube_trailer;
        this.url = url;
    }

    public /* synthetic */ HomeRes(String str, String str2, String str3, CustomTag customTag, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : customTag, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? "" : str7, (i & 256) == 0 ? str8 : "", (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? null : str13, (i & 16384) != 0 ? null : str14, (i & 32768) != 0 ? null : str15);
    }

    @Nullable
    public final String getTMDB_ID() {
        return this.TMDB_ID;
    }

    @Nullable
    public final String getBanner() {
        return this.banner;
    }

    @Nullable
    public final String getContent_type() {
        return this.content_type;
    }

    @Nullable
    public final CustomTag getCustom_tag() {
        return this.custom_tag;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDownloadable() {
        return this.downloadable;
    }

    @Nullable
    public final String getGenres() {
        return this.genres;
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
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    public final String getRelease_date() {
        return this.release_date;
    }

    @Nullable
    public final String getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getYoutube_trailer() {
        return this.youtube_trailer;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
