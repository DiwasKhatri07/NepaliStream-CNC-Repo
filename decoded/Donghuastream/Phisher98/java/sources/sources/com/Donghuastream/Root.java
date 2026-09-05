package com.Donghuastream;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Donghuastreamparser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Donghuastream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\rHÆ\u0003J\u0081\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rHÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u00061"}, d2 = {"Lcom/Donghuastream/Root;", "", "status", "", "server_time", "query", "Lcom/Donghuastream/Query;", "embed_link", "download_link", "request_link", "title", "poster", "sources", "", "Lcom/Donghuastream/Source;", "tracks", "Lcom/Donghuastream/Track;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/Donghuastream/Query;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getStatus", "()Ljava/lang/String;", "getServer_time", "getQuery", "()Lcom/Donghuastream/Query;", "getEmbed_link", "getDownload_link", "getRequest_link", "getTitle", "getPoster", "getSources", "()Ljava/util/List;", "getTracks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Root {

    @Nullable
    private final String download_link;

    @Nullable
    private final String embed_link;

    @NotNull
    private final String poster;

    @NotNull
    private final Query query;

    @Nullable
    private final String request_link;

    @Nullable
    private final String server_time;

    @NotNull
    private final List<Source> sources;

    @NotNull
    private final String status;

    @NotNull
    private final String title;

    @NotNull
    private final List<Track> tracks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Root copy$default(Root root, String str, String str2, Query query, String str3, String str4, String str5, String str6, String str7, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = root.status;
        }
        if ((i & 2) != 0) {
            str2 = root.server_time;
        }
        if ((i & 4) != 0) {
            query = root.query;
        }
        if ((i & 8) != 0) {
            str3 = root.embed_link;
        }
        if ((i & 16) != 0) {
            str4 = root.download_link;
        }
        if ((i & 32) != 0) {
            str5 = root.request_link;
        }
        if ((i & 64) != 0) {
            str6 = root.title;
        }
        if ((i & 128) != 0) {
            str7 = root.poster;
        }
        if ((i & 256) != 0) {
            list = root.sources;
        }
        if ((i & 512) != 0) {
            list2 = root.tracks;
        }
        List list3 = list;
        List list4 = list2;
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        return root.copy(str, str2, query, str3, str10, str11, str8, str9, list3, list4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final List<Track> component10() {
        return this.tracks;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getServer_time() {
        return this.server_time;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Query getQuery() {
        return this.query;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEmbed_link() {
        return this.embed_link;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDownload_link() {
        return this.download_link;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRequest_link() {
        return this.request_link;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPoster() {
        return this.poster;
    }

    @NotNull
    public final List<Source> component9() {
        return this.sources;
    }

    @NotNull
    public final Root copy(@NotNull String status, @Nullable String server_time, @NotNull Query query, @Nullable String embed_link, @Nullable String download_link, @Nullable String request_link, @NotNull String title, @NotNull String poster, @NotNull List<Source> sources, @NotNull List<Track> tracks) {
        return new Root(status, server_time, query, embed_link, download_link, request_link, title, poster, sources, tracks);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Root)) {
            return false;
        }
        Root root = (Root) other;
        return Intrinsics.areEqual(this.status, root.status) && Intrinsics.areEqual(this.server_time, root.server_time) && Intrinsics.areEqual(this.query, root.query) && Intrinsics.areEqual(this.embed_link, root.embed_link) && Intrinsics.areEqual(this.download_link, root.download_link) && Intrinsics.areEqual(this.request_link, root.request_link) && Intrinsics.areEqual(this.title, root.title) && Intrinsics.areEqual(this.poster, root.poster) && Intrinsics.areEqual(this.sources, root.sources) && Intrinsics.areEqual(this.tracks, root.tracks);
    }

    public int hashCode() {
        return (((((((((((((((((this.status.hashCode() * 31) + (this.server_time == null ? 0 : this.server_time.hashCode())) * 31) + this.query.hashCode()) * 31) + (this.embed_link == null ? 0 : this.embed_link.hashCode())) * 31) + (this.download_link == null ? 0 : this.download_link.hashCode())) * 31) + (this.request_link != null ? this.request_link.hashCode() : 0)) * 31) + this.title.hashCode()) * 31) + this.poster.hashCode()) * 31) + this.sources.hashCode()) * 31) + this.tracks.hashCode();
    }

    @NotNull
    public String toString() {
        return "Root(status=" + this.status + ", server_time=" + this.server_time + ", query=" + this.query + ", embed_link=" + this.embed_link + ", download_link=" + this.download_link + ", request_link=" + this.request_link + ", title=" + this.title + ", poster=" + this.poster + ", sources=" + this.sources + ", tracks=" + this.tracks + ')';
    }

    public Root(@NotNull String status, @Nullable String server_time, @NotNull Query query, @Nullable String embed_link, @Nullable String download_link, @Nullable String request_link, @NotNull String title, @NotNull String poster, @NotNull List<Source> list, @NotNull List<Track> list2) {
        this.status = status;
        this.server_time = server_time;
        this.query = query;
        this.embed_link = embed_link;
        this.download_link = download_link;
        this.request_link = request_link;
        this.title = title;
        this.poster = poster;
        this.sources = list;
        this.tracks = list2;
    }

    public /* synthetic */ Root(String str, String str2, Query query, String str3, String str4, String str5, String str6, String str7, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, query, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, str6, str7, list, list2);
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getServer_time() {
        return this.server_time;
    }

    @NotNull
    public final Query getQuery() {
        return this.query;
    }

    @Nullable
    public final String getEmbed_link() {
        return this.embed_link;
    }

    @Nullable
    public final String getDownload_link() {
        return this.download_link;
    }

    @Nullable
    public final String getRequest_link() {
        return this.request_link;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getPoster() {
        return this.poster;
    }

    @NotNull
    public final List<Source> getSources() {
        return this.sources;
    }

    @NotNull
    public final List<Track> getTracks() {
        return this.tracks;
    }
}
