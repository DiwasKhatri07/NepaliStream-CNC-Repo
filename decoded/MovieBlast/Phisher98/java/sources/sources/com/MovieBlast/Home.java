package com.MovieBlast;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MovieBlastParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MovieBlast/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b\u0012\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00130\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0094\u0002\u0010=\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010>J\u0014\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010B\u001a\u00020CHÖ\u0081\u0004J\n\u0010D\u001a\u00020\u000bHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010 R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010 ¨\u0006E"}, d2 = {"Lcom/MovieBlast/Home;", "", "currentPage", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "current_page", "data", "", "Lcom/MovieBlast/HomeDaum;", "firstPageUrl", "", "first_page_url", "from", "lastPage", "last_page", "lastPageUrl", "last_page_url", "links", "Lcom/MovieBlast/HomeLink;", "nextPageUrl", "next_page_url", "path", "perPage", "per_page", "prevPageUrl", "prev_page_url", "to", "total", "<init>", "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getCurrentPage", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getData", "()Ljava/util/List;", "getFirstPageUrl", "()Ljava/lang/String;", "getFrom", "getLastPage", "getLastPageUrl", "getLinks", "getNextPageUrl", "getPath", "getPerPage", "getPrevPageUrl", "getTo", "getTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/MovieBlast/Home;", "equals", "", "other", "hashCode", "", "toString", "MovieBlast"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Home {

    @Nullable
    private final Long currentPage;

    @NotNull
    private final List<HomeDaum> data;

    @Nullable
    private final String firstPageUrl;

    @Nullable
    private final Long from;

    @Nullable
    private final Long lastPage;

    @Nullable
    private final String lastPageUrl;

    @NotNull
    private final List<HomeLink> links;

    @Nullable
    private final String nextPageUrl;

    @Nullable
    private final String path;

    @Nullable
    private final Long perPage;

    @Nullable
    private final String prevPageUrl;

    @Nullable
    private final Long to;

    @Nullable
    private final Long total;

    public Home() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Home copy$default(Home home, Long l, List list, String str, Long l2, Long l3, String str2, List list2, String str3, String str4, Long l4, String str5, Long l5, Long l6, int i, Object obj) {
        if ((i & 1) != 0) {
            l = home.currentPage;
        }
        return home.copy(l, (i & 2) != 0 ? home.data : list, (i & 4) != 0 ? home.firstPageUrl : str, (i & 8) != 0 ? home.from : l2, (i & 16) != 0 ? home.lastPage : l3, (i & 32) != 0 ? home.lastPageUrl : str2, (i & 64) != 0 ? home.links : list2, (i & 128) != 0 ? home.nextPageUrl : str3, (i & 256) != 0 ? home.path : str4, (i & 512) != 0 ? home.perPage : l4, (i & 1024) != 0 ? home.prevPageUrl : str5, (i & 2048) != 0 ? home.to : l5, (i & 4096) != 0 ? home.total : l6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getCurrentPage() {
        return this.currentPage;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getPerPage() {
        return this.perPage;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPrevPageUrl() {
        return this.prevPageUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Long getTo() {
        return this.to;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Long getTotal() {
        return this.total;
    }

    @NotNull
    public final List<HomeDaum> component2() {
        return this.data;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFirstPageUrl() {
        return this.firstPageUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getFrom() {
        return this.from;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getLastPage() {
        return this.lastPage;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLastPageUrl() {
        return this.lastPageUrl;
    }

    @NotNull
    public final List<HomeLink> component7() {
        return this.links;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getNextPageUrl() {
        return this.nextPageUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final Home copy(@JsonProperty("current_page") @Nullable Long currentPage, @NotNull List<HomeDaum> data, @JsonProperty("first_page_url") @Nullable String firstPageUrl, @Nullable Long from, @JsonProperty("last_page") @Nullable Long lastPage, @JsonProperty("last_page_url") @Nullable String lastPageUrl, @NotNull List<HomeLink> links, @JsonProperty("next_page_url") @Nullable String nextPageUrl, @Nullable String path, @JsonProperty("per_page") @Nullable Long perPage, @JsonProperty("prev_page_url") @Nullable String prevPageUrl, @Nullable Long to, @Nullable Long total) {
        return new Home(currentPage, data, firstPageUrl, from, lastPage, lastPageUrl, links, nextPageUrl, path, perPage, prevPageUrl, to, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Home)) {
            return false;
        }
        Home home = (Home) other;
        return Intrinsics.areEqual(this.currentPage, home.currentPage) && Intrinsics.areEqual(this.data, home.data) && Intrinsics.areEqual(this.firstPageUrl, home.firstPageUrl) && Intrinsics.areEqual(this.from, home.from) && Intrinsics.areEqual(this.lastPage, home.lastPage) && Intrinsics.areEqual(this.lastPageUrl, home.lastPageUrl) && Intrinsics.areEqual(this.links, home.links) && Intrinsics.areEqual(this.nextPageUrl, home.nextPageUrl) && Intrinsics.areEqual(this.path, home.path) && Intrinsics.areEqual(this.perPage, home.perPage) && Intrinsics.areEqual(this.prevPageUrl, home.prevPageUrl) && Intrinsics.areEqual(this.to, home.to) && Intrinsics.areEqual(this.total, home.total);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((this.currentPage == null ? 0 : this.currentPage.hashCode()) * 31) + this.data.hashCode()) * 31) + (this.firstPageUrl == null ? 0 : this.firstPageUrl.hashCode())) * 31) + (this.from == null ? 0 : this.from.hashCode())) * 31) + (this.lastPage == null ? 0 : this.lastPage.hashCode())) * 31) + (this.lastPageUrl == null ? 0 : this.lastPageUrl.hashCode())) * 31) + this.links.hashCode()) * 31) + (this.nextPageUrl == null ? 0 : this.nextPageUrl.hashCode())) * 31) + (this.path == null ? 0 : this.path.hashCode())) * 31) + (this.perPage == null ? 0 : this.perPage.hashCode())) * 31) + (this.prevPageUrl == null ? 0 : this.prevPageUrl.hashCode())) * 31) + (this.to == null ? 0 : this.to.hashCode())) * 31) + (this.total != null ? this.total.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Home(currentPage=").append(this.currentPage).append(", data=").append(this.data).append(", firstPageUrl=").append(this.firstPageUrl).append(", from=").append(this.from).append(", lastPage=").append(this.lastPage).append(", lastPageUrl=").append(this.lastPageUrl).append(", links=").append(this.links).append(", nextPageUrl=").append(this.nextPageUrl).append(", path=").append(this.path).append(", perPage=").append(this.perPage).append(", prevPageUrl=").append(this.prevPageUrl).append(", to=");
        sb.append(this.to).append(", total=").append(this.total).append(')');
        return sb.toString();
    }

    public Home(@JsonProperty("current_page") @Nullable Long currentPage, @NotNull List<HomeDaum> list, @JsonProperty("first_page_url") @Nullable String firstPageUrl, @Nullable Long from, @JsonProperty("last_page") @Nullable Long lastPage, @JsonProperty("last_page_url") @Nullable String lastPageUrl, @NotNull List<HomeLink> list2, @JsonProperty("next_page_url") @Nullable String nextPageUrl, @Nullable String path, @JsonProperty("per_page") @Nullable Long perPage, @JsonProperty("prev_page_url") @Nullable String prevPageUrl, @Nullable Long to, @Nullable Long total) {
        this.currentPage = currentPage;
        this.data = list;
        this.firstPageUrl = firstPageUrl;
        this.from = from;
        this.lastPage = lastPage;
        this.lastPageUrl = lastPageUrl;
        this.links = list2;
        this.nextPageUrl = nextPageUrl;
        this.path = path;
        this.perPage = perPage;
        this.prevPageUrl = prevPageUrl;
        this.to = to;
        this.total = total;
    }

    public /* synthetic */ Home(Long l, List list, String str, Long l2, Long l3, String str2, List list2, String str3, String str4, Long l4, String str5, Long l5, Long l6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : l3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? CollectionsKt.emptyList() : list2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : l4, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : l5, (i & 4096) == 0 ? l6 : null);
    }

    @Nullable
    public final Long getCurrentPage() {
        return this.currentPage;
    }

    @NotNull
    public final List<HomeDaum> getData() {
        return this.data;
    }

    @Nullable
    public final String getFirstPageUrl() {
        return this.firstPageUrl;
    }

    @Nullable
    public final Long getFrom() {
        return this.from;
    }

    @Nullable
    public final Long getLastPage() {
        return this.lastPage;
    }

    @Nullable
    public final String getLastPageUrl() {
        return this.lastPageUrl;
    }

    @NotNull
    public final List<HomeLink> getLinks() {
        return this.links;
    }

    @Nullable
    public final String getNextPageUrl() {
        return this.nextPageUrl;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final Long getPerPage() {
        return this.perPage;
    }

    @Nullable
    public final String getPrevPageUrl() {
        return this.prevPageUrl;
    }

    @Nullable
    public final Long getTo() {
        return this.to;
    }

    @Nullable
    public final Long getTotal() {
        return this.total;
    }
}
