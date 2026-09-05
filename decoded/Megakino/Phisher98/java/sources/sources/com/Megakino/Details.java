package com.Megakino;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Megakino/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b>\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003JÍ\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001J\u0014\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010D\u001a\u00020EHÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019¨\u0006G"}, d2 = {"Lcom/Megakino/Details;", "", "id", "", "uid", "slug", "title", "folderid", "quality", "sources", "type", "userlinkhost", "poster", "subtitles", "added", "updatedtime", "status", "errorcount", "progressbar", "progress", "views", "md5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getUid", "getSlug", "getTitle", "getFolderid", "()Ljava/lang/Object;", "getQuality", "getSources", "getType", "getUserlinkhost", "getPoster", "getSubtitles", "getAdded", "getUpdatedtime", "getStatus", "getErrorcount", "getProgressbar", "getProgress", "getViews", "getMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "", "other", "hashCode", "", "toString", "Megakino"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Details {

    @NotNull
    private final String added;

    @NotNull
    private final String errorcount;

    @Nullable
    private final Object folderid;

    @NotNull
    private final String id;

    @NotNull
    private final String md5;

    @NotNull
    private final String poster;

    @NotNull
    private final String progress;

    @NotNull
    private final String progressbar;

    @NotNull
    private final String quality;

    @NotNull
    private final String slug;

    @Nullable
    private final Object sources;

    @NotNull
    private final String status;

    @Nullable
    private final Object subtitles;

    @NotNull
    private final String title;

    @NotNull
    private final String type;

    @NotNull
    private final String uid;

    @NotNull
    private final String updatedtime;

    @NotNull
    private final String userlinkhost;

    @NotNull
    private final String views;

    public static /* synthetic */ Details copy$default(Details details, String str, String str2, String str3, String str4, Object obj, String str5, Object obj2, String str6, String str7, String str8, Object obj3, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, Object obj4) {
        String str17;
        String str18;
        String str19 = (i & 1) != 0 ? details.id : str;
        String str20 = (i & 2) != 0 ? details.uid : str2;
        String str21 = (i & 4) != 0 ? details.slug : str3;
        String str22 = (i & 8) != 0 ? details.title : str4;
        Object obj5 = (i & 16) != 0 ? details.folderid : obj;
        String str23 = (i & 32) != 0 ? details.quality : str5;
        Object obj6 = (i & 64) != 0 ? details.sources : obj2;
        String str24 = (i & 128) != 0 ? details.type : str6;
        String str25 = (i & 256) != 0 ? details.userlinkhost : str7;
        String str26 = (i & 512) != 0 ? details.poster : str8;
        Object obj7 = (i & 1024) != 0 ? details.subtitles : obj3;
        String str27 = (i & 2048) != 0 ? details.added : str9;
        String str28 = (i & 4096) != 0 ? details.updatedtime : str10;
        String str29 = (i & 8192) != 0 ? details.status : str11;
        String str30 = str19;
        String str31 = (i & 16384) != 0 ? details.errorcount : str12;
        String str32 = (i & 32768) != 0 ? details.progressbar : str13;
        String str33 = (i & 65536) != 0 ? details.progress : str14;
        String str34 = (i & 131072) != 0 ? details.views : str15;
        if ((i & 262144) != 0) {
            str18 = str34;
            str17 = details.md5;
        } else {
            str17 = str16;
            str18 = str34;
        }
        return details.copy(str30, str20, str21, str22, obj5, str23, obj6, str24, str25, str26, obj7, str27, str28, str29, str31, str32, str33, str18, str17);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Object getSubtitles() {
        return this.subtitles;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getAdded() {
        return this.added;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getUpdatedtime() {
        return this.updatedtime;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getErrorcount() {
        return this.errorcount;
    }

    @NotNull
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getProgressbar() {
        return this.progressbar;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getProgress() {
        return this.progress;
    }

    @NotNull
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getViews() {
        return this.views;
    }

    @NotNull
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Object getFolderid() {
        return this.folderid;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getSources() {
        return this.sources;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getUserlinkhost() {
        return this.userlinkhost;
    }

    @NotNull
    public final Details copy(@NotNull String id, @NotNull String uid, @NotNull String slug, @NotNull String title, @Nullable Object folderid, @NotNull String quality, @Nullable Object sources, @NotNull String type, @NotNull String userlinkhost, @NotNull String poster, @Nullable Object subtitles, @NotNull String added, @NotNull String updatedtime, @NotNull String status, @NotNull String errorcount, @NotNull String progressbar, @NotNull String progress, @NotNull String views, @NotNull String md5) {
        return new Details(id, uid, slug, title, folderid, quality, sources, type, userlinkhost, poster, subtitles, added, updatedtime, status, errorcount, progressbar, progress, views, md5);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Details)) {
            return false;
        }
        Details details = (Details) other;
        return Intrinsics.areEqual(this.id, details.id) && Intrinsics.areEqual(this.uid, details.uid) && Intrinsics.areEqual(this.slug, details.slug) && Intrinsics.areEqual(this.title, details.title) && Intrinsics.areEqual(this.folderid, details.folderid) && Intrinsics.areEqual(this.quality, details.quality) && Intrinsics.areEqual(this.sources, details.sources) && Intrinsics.areEqual(this.type, details.type) && Intrinsics.areEqual(this.userlinkhost, details.userlinkhost) && Intrinsics.areEqual(this.poster, details.poster) && Intrinsics.areEqual(this.subtitles, details.subtitles) && Intrinsics.areEqual(this.added, details.added) && Intrinsics.areEqual(this.updatedtime, details.updatedtime) && Intrinsics.areEqual(this.status, details.status) && Intrinsics.areEqual(this.errorcount, details.errorcount) && Intrinsics.areEqual(this.progressbar, details.progressbar) && Intrinsics.areEqual(this.progress, details.progress) && Intrinsics.areEqual(this.views, details.views) && Intrinsics.areEqual(this.md5, details.md5);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.uid.hashCode()) * 31) + this.slug.hashCode()) * 31) + this.title.hashCode()) * 31) + (this.folderid == null ? 0 : this.folderid.hashCode())) * 31) + this.quality.hashCode()) * 31) + (this.sources == null ? 0 : this.sources.hashCode())) * 31) + this.type.hashCode()) * 31) + this.userlinkhost.hashCode()) * 31) + this.poster.hashCode()) * 31) + (this.subtitles != null ? this.subtitles.hashCode() : 0)) * 31) + this.added.hashCode()) * 31) + this.updatedtime.hashCode()) * 31) + this.status.hashCode()) * 31) + this.errorcount.hashCode()) * 31) + this.progressbar.hashCode()) * 31) + this.progress.hashCode()) * 31) + this.views.hashCode()) * 31) + this.md5.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Details(id=").append(this.id).append(", uid=").append(this.uid).append(", slug=").append(this.slug).append(", title=").append(this.title).append(", folderid=").append(this.folderid).append(", quality=").append(this.quality).append(", sources=").append(this.sources).append(", type=").append(this.type).append(", userlinkhost=").append(this.userlinkhost).append(", poster=").append(this.poster).append(", subtitles=").append(this.subtitles).append(", added=");
        sb.append(this.added).append(", updatedtime=").append(this.updatedtime).append(", status=").append(this.status).append(", errorcount=").append(this.errorcount).append(", progressbar=").append(this.progressbar).append(", progress=").append(this.progress).append(", views=").append(this.views).append(", md5=").append(this.md5).append(')');
        return sb.toString();
    }

    public Details(@NotNull String id, @NotNull String uid, @NotNull String slug, @NotNull String title, @Nullable Object folderid, @NotNull String quality, @Nullable Object sources, @NotNull String type, @NotNull String userlinkhost, @NotNull String poster, @Nullable Object subtitles, @NotNull String added, @NotNull String updatedtime, @NotNull String status, @NotNull String errorcount, @NotNull String progressbar, @NotNull String progress, @NotNull String views, @NotNull String md5) {
        this.id = id;
        this.uid = uid;
        this.slug = slug;
        this.title = title;
        this.folderid = folderid;
        this.quality = quality;
        this.sources = sources;
        this.type = type;
        this.userlinkhost = userlinkhost;
        this.poster = poster;
        this.subtitles = subtitles;
        this.added = added;
        this.updatedtime = updatedtime;
        this.status = status;
        this.errorcount = errorcount;
        this.progressbar = progressbar;
        this.progress = progress;
        this.views = views;
        this.md5 = md5;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Object getFolderid() {
        return this.folderid;
    }

    @NotNull
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final Object getSources() {
        return this.sources;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getUserlinkhost() {
        return this.userlinkhost;
    }

    @NotNull
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    public final Object getSubtitles() {
        return this.subtitles;
    }

    @NotNull
    public final String getAdded() {
        return this.added;
    }

    @NotNull
    public final String getUpdatedtime() {
        return this.updatedtime;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getErrorcount() {
        return this.errorcount;
    }

    @NotNull
    public final String getProgressbar() {
        return this.progressbar;
    }

    @NotNull
    public final String getProgress() {
        return this.progress;
    }

    @NotNull
    public final String getViews() {
        return this.views;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }
}
