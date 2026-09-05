package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0004\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0001\u0010\b\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0016\b\u0001\u0010\n\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0001:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0018\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0001:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J³\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0003\u0010\u0004\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\b\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t2\u0016\b\u0003\u0010\n\u001a\u00020\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0001:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0001:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0001J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u000201HÖ\u0081\u0004J\n\u00102\u001a\u000203HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00064"}, d2 = {"Lcom/phisher98/animepahe;", "", "total", "", "perPage", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "per_page", "currentPage", "current_page", "lastPage", "last_page", "nextPageUrl", "next_page_url", "prevPageUrl", "prev_page_url", "from", "to", "data", "", "Lcom/phisher98/Daum;", "<init>", "(JJJJLjava/lang/Object;Ljava/lang/Object;JJLjava/util/List;)V", "getTotal", "()J", "getPerPage", "getCurrentPage", "getLastPage", "getNextPageUrl", "()Ljava/lang/Object;", "getPrevPageUrl", "getFrom", "getTo", "getData", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class animepahe {
    private final long currentPage;

    @NotNull
    private final List<Daum> data;
    private final long from;
    private final long lastPage;

    @Nullable
    private final Object nextPageUrl;
    private final long perPage;

    @Nullable
    private final Object prevPageUrl;
    private final long to;
    private final long total;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPerPage() {
        return this.perPage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCurrentPage() {
        return this.currentPage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getLastPage() {
        return this.lastPage;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Object getNextPageUrl() {
        return this.nextPageUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getPrevPageUrl() {
        return this.prevPageUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getFrom() {
        return this.from;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getTo() {
        return this.to;
    }

    @NotNull
    public final List<Daum> component9() {
        return this.data;
    }

    @NotNull
    public final animepahe copy(long total, @JsonProperty("per_page") long perPage, @JsonProperty("current_page") long currentPage, @JsonProperty("last_page") long lastPage, @JsonProperty("next_page_url") @Nullable Object nextPageUrl, @JsonProperty("prev_page_url") @Nullable Object prevPageUrl, long from, long to, @NotNull List<Daum> data) {
        return new animepahe(total, perPage, currentPage, lastPage, nextPageUrl, prevPageUrl, from, to, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof animepahe)) {
            return false;
        }
        animepahe animepaheVar = (animepahe) other;
        return this.total == animepaheVar.total && this.perPage == animepaheVar.perPage && this.currentPage == animepaheVar.currentPage && this.lastPage == animepaheVar.lastPage && Intrinsics.areEqual(this.nextPageUrl, animepaheVar.nextPageUrl) && Intrinsics.areEqual(this.prevPageUrl, animepaheVar.prevPageUrl) && this.from == animepaheVar.from && this.to == animepaheVar.to && Intrinsics.areEqual(this.data, animepaheVar.data);
    }

    public int hashCode() {
        return (((((((((((((((animepahe$$ExternalSyntheticBackport0.m37m(this.total) * 31) + animepahe$$ExternalSyntheticBackport0.m37m(this.perPage)) * 31) + animepahe$$ExternalSyntheticBackport0.m37m(this.currentPage)) * 31) + animepahe$$ExternalSyntheticBackport0.m37m(this.lastPage)) * 31) + (this.nextPageUrl == null ? 0 : this.nextPageUrl.hashCode())) * 31) + (this.prevPageUrl != null ? this.prevPageUrl.hashCode() : 0)) * 31) + animepahe$$ExternalSyntheticBackport0.m37m(this.from)) * 31) + animepahe$$ExternalSyntheticBackport0.m37m(this.to)) * 31) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "animepahe(total=" + this.total + ", perPage=" + this.perPage + ", currentPage=" + this.currentPage + ", lastPage=" + this.lastPage + ", nextPageUrl=" + this.nextPageUrl + ", prevPageUrl=" + this.prevPageUrl + ", from=" + this.from + ", to=" + this.to + ", data=" + this.data + ')';
    }

    public animepahe(long total, @JsonProperty("per_page") long perPage, @JsonProperty("current_page") long currentPage, @JsonProperty("last_page") long lastPage, @JsonProperty("next_page_url") @Nullable Object nextPageUrl, @JsonProperty("prev_page_url") @Nullable Object prevPageUrl, long from, long to, @NotNull List<Daum> list) {
        this.total = total;
        this.perPage = perPage;
        this.currentPage = currentPage;
        this.lastPage = lastPage;
        this.nextPageUrl = nextPageUrl;
        this.prevPageUrl = prevPageUrl;
        this.from = from;
        this.to = to;
        this.data = list;
    }

    public final long getTotal() {
        return this.total;
    }

    public final long getPerPage() {
        return this.perPage;
    }

    public final long getCurrentPage() {
        return this.currentPage;
    }

    public final long getLastPage() {
        return this.lastPage;
    }

    @Nullable
    public final Object getNextPageUrl() {
        return this.nextPageUrl;
    }

    @Nullable
    public final Object getPrevPageUrl() {
        return this.prevPageUrl;
    }

    public final long getFrom() {
        return this.from;
    }

    public final long getTo() {
        return this.to;
    }

    @NotNull
    public final List<Daum> getData() {
        return this.data;
    }
}
