package com.hdhub4u;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/HDhub4u/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u001e\b\u0001\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0016\b\u0001\u0010\u000e\u001a\u00020\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0016\b\u0001\u0010\u0011\u001a\u00020\u0012:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0016\b\u0001\u0010\u0014\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\t\u0010*\u001a\u00020\u0012HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\u00ad\u0001\u0010,\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0016\b\u0003\u0010\u000b\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\b\b\u0002\u0010\r\u001a\u00020\b2\u0016\b\u0003\u0010\u000e\u001a\u00020\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0016\b\u0003\u0010\u0011\u001a\u00020\u0012:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00132\u0016\b\u0003\u0010\u0014\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015HÆ\u0001J\u0014\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u000200HÖ\u0081\u0004J\n\u00101\u001a\u000202HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001b¨\u00063"}, d2 = {"Lcom/hdhub4u/Search;", "", "facetCounts", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "facet_counts", "found", "", "hits", "Lcom/hdhub4u/Hit;", "outOf", "out_of", "page", "requestParams", "Lcom/hdhub4u/RequestParams;", "request_params", "searchCutoff", "", "search_cutoff", "searchTimeMs", "search_time_ms", "<init>", "(Ljava/util/List;JLjava/util/List;JJLcom/hdhub4u/RequestParams;ZJ)V", "getFacetCounts", "()Ljava/util/List;", "getFound", "()J", "getHits", "getOutOf", "getPage", "getRequestParams", "()Lcom/hdhub4u/RequestParams;", "getSearchCutoff", "()Z", "getSearchTimeMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Search {

    @NotNull
    private final List<Object> facetCounts;
    private final long found;

    @NotNull
    private final List<Hit> hits;
    private final long outOf;
    private final long page;

    @NotNull
    private final RequestParams requestParams;
    private final boolean searchCutoff;
    private final long searchTimeMs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Search copy$default(Search search, List list, long j, List list2, long j2, long j3, RequestParams requestParams, boolean z, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = search.facetCounts;
        }
        if ((i & 2) != 0) {
            j = search.found;
        }
        if ((i & 4) != 0) {
            list2 = search.hits;
        }
        if ((i & 8) != 0) {
            j2 = search.outOf;
        }
        if ((i & 16) != 0) {
            j3 = search.page;
        }
        if ((i & 32) != 0) {
            requestParams = search.requestParams;
        }
        if ((i & 64) != 0) {
            z = search.searchCutoff;
        }
        if ((i & 128) != 0) {
            j4 = search.searchTimeMs;
        }
        long j5 = j3;
        List list3 = list2;
        return search.copy(list, j, list3, j2, j5, requestParams, z, j4);
    }

    @NotNull
    public final List<Object> component1() {
        return this.facetCounts;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getFound() {
        return this.found;
    }

    @NotNull
    public final List<Hit> component3() {
        return this.hits;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getOutOf() {
        return this.outOf;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getPage() {
        return this.page;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final RequestParams getRequestParams() {
        return this.requestParams;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getSearchCutoff() {
        return this.searchCutoff;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getSearchTimeMs() {
        return this.searchTimeMs;
    }

    @NotNull
    public final Search copy(@JsonProperty("facet_counts") @NotNull List<? extends Object> facetCounts, long found, @NotNull List<Hit> hits, @JsonProperty("out_of") long outOf, long page, @JsonProperty("request_params") @NotNull RequestParams requestParams, @JsonProperty("search_cutoff") boolean searchCutoff, @JsonProperty("search_time_ms") long searchTimeMs) {
        return new Search(facetCounts, found, hits, outOf, page, requestParams, searchCutoff, searchTimeMs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Search)) {
            return false;
        }
        Search search = (Search) other;
        return Intrinsics.areEqual(this.facetCounts, search.facetCounts) && this.found == search.found && Intrinsics.areEqual(this.hits, search.hits) && this.outOf == search.outOf && this.page == search.page && Intrinsics.areEqual(this.requestParams, search.requestParams) && this.searchCutoff == search.searchCutoff && this.searchTimeMs == search.searchTimeMs;
    }

    public int hashCode() {
        return (((((((((((((this.facetCounts.hashCode() * 31) + Search$$ExternalSyntheticBackport0.m3m(this.found)) * 31) + this.hits.hashCode()) * 31) + Search$$ExternalSyntheticBackport0.m3m(this.outOf)) * 31) + Search$$ExternalSyntheticBackport0.m3m(this.page)) * 31) + this.requestParams.hashCode()) * 31) + Search$$ExternalSyntheticBackport1.m4m(this.searchCutoff)) * 31) + Search$$ExternalSyntheticBackport0.m3m(this.searchTimeMs);
    }

    @NotNull
    public String toString() {
        return "Search(facetCounts=" + this.facetCounts + ", found=" + this.found + ", hits=" + this.hits + ", outOf=" + this.outOf + ", page=" + this.page + ", requestParams=" + this.requestParams + ", searchCutoff=" + this.searchCutoff + ", searchTimeMs=" + this.searchTimeMs + ')';
    }

    public Search(@JsonProperty("facet_counts") @NotNull List<? extends Object> list, long found, @NotNull List<Hit> list2, @JsonProperty("out_of") long outOf, long page, @JsonProperty("request_params") @NotNull RequestParams requestParams, @JsonProperty("search_cutoff") boolean searchCutoff, @JsonProperty("search_time_ms") long searchTimeMs) {
        this.facetCounts = list;
        this.found = found;
        this.hits = list2;
        this.outOf = outOf;
        this.page = page;
        this.requestParams = requestParams;
        this.searchCutoff = searchCutoff;
        this.searchTimeMs = searchTimeMs;
    }

    @NotNull
    public final List<Object> getFacetCounts() {
        return this.facetCounts;
    }

    public final long getFound() {
        return this.found;
    }

    @NotNull
    public final List<Hit> getHits() {
        return this.hits;
    }

    public final long getOutOf() {
        return this.outOf;
    }

    public final long getPage() {
        return this.page;
    }

    @NotNull
    public final RequestParams getRequestParams() {
        return this.requestParams;
    }

    public final boolean getSearchCutoff() {
        return this.searchCutoff;
    }

    public final long getSearchTimeMs() {
        return this.searchTimeMs;
    }
}
