package com.IStreamFlare;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IStreamFlare/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J©\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0014\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010:\u001a\u00020;HÖ\u0081\u0004J\n\u0010<\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006="}, d2 = {"Lcom/IStreamFlare/StreamLinks;", "", "id", "", "name", "size", "quality", "link_order", "movie_id", "url", "type", "status", "skip_available", "intro_start", "intro_end", "end_credits_marker", "link_type", "drm_uuid", "drm_license_uri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getSize", "getQuality", "getLink_order", "getMovie_id", "getUrl", "getType", "getStatus", "getSkip_available", "getIntro_start", "getIntro_end", "getEnd_credits_marker", "getLink_type", "getDrm_uuid", "getDrm_license_uri", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "hashCode", "", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class StreamLinks {

    @NotNull
    private final String drm_license_uri;

    @NotNull
    private final String drm_uuid;

    @NotNull
    private final String end_credits_marker;

    @NotNull
    private final String id;

    @NotNull
    private final String intro_end;

    @NotNull
    private final String intro_start;

    @NotNull
    private final String link_order;

    @NotNull
    private final String link_type;

    @NotNull
    private final String movie_id;

    @NotNull
    private final String name;

    @NotNull
    private final String quality;

    @NotNull
    private final String size;

    @NotNull
    private final String skip_available;

    @NotNull
    private final String status;

    @NotNull
    private final String type;

    @NotNull
    private final String url;

    public StreamLinks() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public static /* synthetic */ StreamLinks copy$default(StreamLinks streamLinks, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, Object obj) {
        String str17 = (i & 1) != 0 ? streamLinks.id : str;
        return streamLinks.copy(str17, (i & 2) != 0 ? streamLinks.name : str2, (i & 4) != 0 ? streamLinks.size : str3, (i & 8) != 0 ? streamLinks.quality : str4, (i & 16) != 0 ? streamLinks.link_order : str5, (i & 32) != 0 ? streamLinks.movie_id : str6, (i & 64) != 0 ? streamLinks.url : str7, (i & 128) != 0 ? streamLinks.type : str8, (i & 256) != 0 ? streamLinks.status : str9, (i & 512) != 0 ? streamLinks.skip_available : str10, (i & 1024) != 0 ? streamLinks.intro_start : str11, (i & 2048) != 0 ? streamLinks.intro_end : str12, (i & 4096) != 0 ? streamLinks.end_credits_marker : str13, (i & 8192) != 0 ? streamLinks.link_type : str14, (i & 16384) != 0 ? streamLinks.drm_uuid : str15, (i & 32768) != 0 ? streamLinks.drm_license_uri : str16);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSkip_available() {
        return this.skip_available;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getIntro_start() {
        return this.intro_start;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getIntro_end() {
        return this.intro_end;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getEnd_credits_marker() {
        return this.end_credits_marker;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getLink_type() {
        return this.link_type;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getDrm_uuid() {
        return this.drm_uuid;
    }

    @NotNull
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getDrm_license_uri() {
        return this.drm_license_uri;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSize() {
        return this.size;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLink_order() {
        return this.link_order;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMovie_id() {
        return this.movie_id;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUrl() {
        return this.url;
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
    public final StreamLinks copy(@NotNull String id, @NotNull String name, @NotNull String size, @NotNull String quality, @NotNull String link_order, @NotNull String movie_id, @NotNull String url, @NotNull String type, @NotNull String status, @NotNull String skip_available, @NotNull String intro_start, @NotNull String intro_end, @NotNull String end_credits_marker, @NotNull String link_type, @NotNull String drm_uuid, @NotNull String drm_license_uri) {
        return new StreamLinks(id, name, size, quality, link_order, movie_id, url, type, status, skip_available, intro_start, intro_end, end_credits_marker, link_type, drm_uuid, drm_license_uri);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamLinks)) {
            return false;
        }
        StreamLinks streamLinks = (StreamLinks) other;
        return Intrinsics.areEqual(this.id, streamLinks.id) && Intrinsics.areEqual(this.name, streamLinks.name) && Intrinsics.areEqual(this.size, streamLinks.size) && Intrinsics.areEqual(this.quality, streamLinks.quality) && Intrinsics.areEqual(this.link_order, streamLinks.link_order) && Intrinsics.areEqual(this.movie_id, streamLinks.movie_id) && Intrinsics.areEqual(this.url, streamLinks.url) && Intrinsics.areEqual(this.type, streamLinks.type) && Intrinsics.areEqual(this.status, streamLinks.status) && Intrinsics.areEqual(this.skip_available, streamLinks.skip_available) && Intrinsics.areEqual(this.intro_start, streamLinks.intro_start) && Intrinsics.areEqual(this.intro_end, streamLinks.intro_end) && Intrinsics.areEqual(this.end_credits_marker, streamLinks.end_credits_marker) && Intrinsics.areEqual(this.link_type, streamLinks.link_type) && Intrinsics.areEqual(this.drm_uuid, streamLinks.drm_uuid) && Intrinsics.areEqual(this.drm_license_uri, streamLinks.drm_license_uri);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.size.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.link_order.hashCode()) * 31) + this.movie_id.hashCode()) * 31) + this.url.hashCode()) * 31) + this.type.hashCode()) * 31) + this.status.hashCode()) * 31) + this.skip_available.hashCode()) * 31) + this.intro_start.hashCode()) * 31) + this.intro_end.hashCode()) * 31) + this.end_credits_marker.hashCode()) * 31) + this.link_type.hashCode()) * 31) + this.drm_uuid.hashCode()) * 31) + this.drm_license_uri.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StreamLinks(id=").append(this.id).append(", name=").append(this.name).append(", size=").append(this.size).append(", quality=").append(this.quality).append(", link_order=").append(this.link_order).append(", movie_id=").append(this.movie_id).append(", url=").append(this.url).append(", type=").append(this.type).append(", status=").append(this.status).append(", skip_available=").append(this.skip_available).append(", intro_start=").append(this.intro_start).append(", intro_end=");
        sb.append(this.intro_end).append(", end_credits_marker=").append(this.end_credits_marker).append(", link_type=").append(this.link_type).append(", drm_uuid=").append(this.drm_uuid).append(", drm_license_uri=").append(this.drm_license_uri).append(')');
        return sb.toString();
    }

    public StreamLinks(@NotNull String id, @NotNull String name, @NotNull String size, @NotNull String quality, @NotNull String link_order, @NotNull String movie_id, @NotNull String url, @NotNull String type, @NotNull String status, @NotNull String skip_available, @NotNull String intro_start, @NotNull String intro_end, @NotNull String end_credits_marker, @NotNull String link_type, @NotNull String drm_uuid, @NotNull String drm_license_uri) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.quality = quality;
        this.link_order = link_order;
        this.movie_id = movie_id;
        this.url = url;
        this.type = type;
        this.status = status;
        this.skip_available = skip_available;
        this.intro_start = intro_start;
        this.intro_end = intro_end;
        this.end_credits_marker = end_credits_marker;
        this.link_type = link_type;
        this.drm_uuid = drm_uuid;
        this.drm_license_uri = drm_license_uri;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StreamLinks(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str17 = (i & 1) != 0 ? "" : str;
        this(str17, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? "" : str12, (i & 4096) != 0 ? "" : str13, (i & 8192) != 0 ? "" : str14, (i & 16384) != 0 ? "" : str15, (i & 32768) == 0 ? str16 : "");
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getSize() {
        return this.size;
    }

    @NotNull
    public final String getQuality() {
        return this.quality;
    }

    @NotNull
    public final String getLink_order() {
        return this.link_order;
    }

    @NotNull
    public final String getMovie_id() {
        return this.movie_id;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
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
    public final String getLink_type() {
        return this.link_type;
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
