package com.IStreamFlare;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/IStreamFlare/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J³\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0014\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020>HÖ\u0081\u0004J\n\u0010?\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006@"}, d2 = {"Lcom/IStreamFlare/EpisodesRes;", "", "id", "", "Episoade_Name", "episoade_image", "episoade_description", "episoade_order", "season_id", "downloadable", "type", "status", "source", "url", "skip_available", "intro_start", "intro_end", "end_credits_marker", "drm_uuid", "drm_license_uri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getEpisoade_Name", "getEpisoade_image", "getEpisoade_description", "getEpisoade_order", "getSeason_id", "getDownloadable", "getType", "getStatus", "getSource", "getUrl", "getSkip_available", "getIntro_start", "getIntro_end", "getEnd_credits_marker", "getDrm_uuid", "getDrm_license_uri", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "", "other", "hashCode", "", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodesRes {

    @NotNull
    private final String Episoade_Name;

    @NotNull
    private final String downloadable;

    @NotNull
    private final String drm_license_uri;

    @NotNull
    private final String drm_uuid;

    @NotNull
    private final String end_credits_marker;

    @NotNull
    private final String episoade_description;

    @NotNull
    private final String episoade_image;

    @NotNull
    private final String episoade_order;

    @NotNull
    private final String id;

    @NotNull
    private final String intro_end;

    @NotNull
    private final String intro_start;

    @NotNull
    private final String season_id;

    @NotNull
    private final String skip_available;

    @NotNull
    private final String source;

    @NotNull
    private final String status;

    @NotNull
    private final String type;

    @NotNull
    private final String url;

    public EpisodesRes() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ EpisodesRes copy$default(EpisodesRes episodesRes, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i, Object obj) {
        String str18;
        String str19;
        String str20 = (i & 1) != 0 ? episodesRes.id : str;
        String str21 = (i & 2) != 0 ? episodesRes.Episoade_Name : str2;
        String str22 = (i & 4) != 0 ? episodesRes.episoade_image : str3;
        String str23 = (i & 8) != 0 ? episodesRes.episoade_description : str4;
        String str24 = (i & 16) != 0 ? episodesRes.episoade_order : str5;
        String str25 = (i & 32) != 0 ? episodesRes.season_id : str6;
        String str26 = (i & 64) != 0 ? episodesRes.downloadable : str7;
        String str27 = (i & 128) != 0 ? episodesRes.type : str8;
        String str28 = (i & 256) != 0 ? episodesRes.status : str9;
        String str29 = (i & 512) != 0 ? episodesRes.source : str10;
        String str30 = (i & 1024) != 0 ? episodesRes.url : str11;
        String str31 = (i & 2048) != 0 ? episodesRes.skip_available : str12;
        String str32 = (i & 4096) != 0 ? episodesRes.intro_start : str13;
        String str33 = (i & 8192) != 0 ? episodesRes.intro_end : str14;
        String str34 = str20;
        String str35 = (i & 16384) != 0 ? episodesRes.end_credits_marker : str15;
        String str36 = (i & 32768) != 0 ? episodesRes.drm_uuid : str16;
        if ((i & 65536) != 0) {
            str19 = str36;
            str18 = episodesRes.drm_license_uri;
        } else {
            str18 = str17;
            str19 = str36;
        }
        return episodesRes.copy(str34, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str35, str19, str18);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getSkip_available() {
        return this.skip_available;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getIntro_start() {
        return this.intro_start;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getIntro_end() {
        return this.intro_end;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getEnd_credits_marker() {
        return this.end_credits_marker;
    }

    @NotNull
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getDrm_uuid() {
        return this.drm_uuid;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getDrm_license_uri() {
        return this.drm_license_uri;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEpisoade_Name() {
        return this.Episoade_Name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEpisoade_image() {
        return this.episoade_image;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEpisoade_description() {
        return this.episoade_description;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEpisoade_order() {
        return this.episoade_order;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSeason_id() {
        return this.season_id;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDownloadable() {
        return this.downloadable;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final EpisodesRes copy(@NotNull String id, @NotNull String Episoade_Name, @NotNull String episoade_image, @NotNull String episoade_description, @NotNull String episoade_order, @NotNull String season_id, @NotNull String downloadable, @NotNull String type, @NotNull String status, @NotNull String source, @NotNull String url, @NotNull String skip_available, @NotNull String intro_start, @NotNull String intro_end, @NotNull String end_credits_marker, @NotNull String drm_uuid, @NotNull String drm_license_uri) {
        return new EpisodesRes(id, Episoade_Name, episoade_image, episoade_description, episoade_order, season_id, downloadable, type, status, source, url, skip_available, intro_start, intro_end, end_credits_marker, drm_uuid, drm_license_uri);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodesRes)) {
            return false;
        }
        EpisodesRes episodesRes = (EpisodesRes) other;
        return Intrinsics.areEqual(this.id, episodesRes.id) && Intrinsics.areEqual(this.Episoade_Name, episodesRes.Episoade_Name) && Intrinsics.areEqual(this.episoade_image, episodesRes.episoade_image) && Intrinsics.areEqual(this.episoade_description, episodesRes.episoade_description) && Intrinsics.areEqual(this.episoade_order, episodesRes.episoade_order) && Intrinsics.areEqual(this.season_id, episodesRes.season_id) && Intrinsics.areEqual(this.downloadable, episodesRes.downloadable) && Intrinsics.areEqual(this.type, episodesRes.type) && Intrinsics.areEqual(this.status, episodesRes.status) && Intrinsics.areEqual(this.source, episodesRes.source) && Intrinsics.areEqual(this.url, episodesRes.url) && Intrinsics.areEqual(this.skip_available, episodesRes.skip_available) && Intrinsics.areEqual(this.intro_start, episodesRes.intro_start) && Intrinsics.areEqual(this.intro_end, episodesRes.intro_end) && Intrinsics.areEqual(this.end_credits_marker, episodesRes.end_credits_marker) && Intrinsics.areEqual(this.drm_uuid, episodesRes.drm_uuid) && Intrinsics.areEqual(this.drm_license_uri, episodesRes.drm_license_uri);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.Episoade_Name.hashCode()) * 31) + this.episoade_image.hashCode()) * 31) + this.episoade_description.hashCode()) * 31) + this.episoade_order.hashCode()) * 31) + this.season_id.hashCode()) * 31) + this.downloadable.hashCode()) * 31) + this.type.hashCode()) * 31) + this.status.hashCode()) * 31) + this.source.hashCode()) * 31) + this.url.hashCode()) * 31) + this.skip_available.hashCode()) * 31) + this.intro_start.hashCode()) * 31) + this.intro_end.hashCode()) * 31) + this.end_credits_marker.hashCode()) * 31) + this.drm_uuid.hashCode()) * 31) + this.drm_license_uri.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EpisodesRes(id=").append(this.id).append(", Episoade_Name=").append(this.Episoade_Name).append(", episoade_image=").append(this.episoade_image).append(", episoade_description=").append(this.episoade_description).append(", episoade_order=").append(this.episoade_order).append(", season_id=").append(this.season_id).append(", downloadable=").append(this.downloadable).append(", type=").append(this.type).append(", status=").append(this.status).append(", source=").append(this.source).append(", url=").append(this.url).append(", skip_available=");
        sb.append(this.skip_available).append(", intro_start=").append(this.intro_start).append(", intro_end=").append(this.intro_end).append(", end_credits_marker=").append(this.end_credits_marker).append(", drm_uuid=").append(this.drm_uuid).append(", drm_license_uri=").append(this.drm_license_uri).append(')');
        return sb.toString();
    }

    public EpisodesRes(@NotNull String id, @NotNull String Episoade_Name, @NotNull String episoade_image, @NotNull String episoade_description, @NotNull String episoade_order, @NotNull String season_id, @NotNull String downloadable, @NotNull String type, @NotNull String status, @NotNull String source, @NotNull String url, @NotNull String skip_available, @NotNull String intro_start, @NotNull String intro_end, @NotNull String end_credits_marker, @NotNull String drm_uuid, @NotNull String drm_license_uri) {
        this.id = id;
        this.Episoade_Name = Episoade_Name;
        this.episoade_image = episoade_image;
        this.episoade_description = episoade_description;
        this.episoade_order = episoade_order;
        this.season_id = season_id;
        this.downloadable = downloadable;
        this.type = type;
        this.status = status;
        this.source = source;
        this.url = url;
        this.skip_available = skip_available;
        this.intro_start = intro_start;
        this.intro_end = intro_end;
        this.end_credits_marker = end_credits_marker;
        this.drm_uuid = drm_uuid;
        this.drm_license_uri = drm_license_uri;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ EpisodesRes(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str18 = (i & 1) != 0 ? "" : str;
        this(str18, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? "" : str12, (i & 4096) != 0 ? "" : str13, (i & 8192) != 0 ? "" : str14, (i & 16384) != 0 ? "" : str15, (i & 32768) != 0 ? "" : str16, (i & 65536) == 0 ? str17 : "");
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getEpisoade_Name() {
        return this.Episoade_Name;
    }

    @NotNull
    public final String getEpisoade_image() {
        return this.episoade_image;
    }

    @NotNull
    public final String getEpisoade_description() {
        return this.episoade_description;
    }

    @NotNull
    public final String getEpisoade_order() {
        return this.episoade_order;
    }

    @NotNull
    public final String getSeason_id() {
        return this.season_id;
    }

    @NotNull
    public final String getDownloadable() {
        return this.downloadable;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getSkip_available() {
        return this.skip_available;
    }

    @NotNull
    public final String getIntro_start() {
        return this.intro_start;
    }

    @NotNull
    public final String getIntro_end() {
        return this.intro_end;
    }

    @NotNull
    public final String getEnd_credits_marker() {
        return this.end_credits_marker;
    }

    @NotNull
    public final String getDrm_uuid() {
        return this.drm_uuid;
    }

    @NotNull
    public final String getDrm_license_uri() {
        return this.drm_license_uri;
    }
}
