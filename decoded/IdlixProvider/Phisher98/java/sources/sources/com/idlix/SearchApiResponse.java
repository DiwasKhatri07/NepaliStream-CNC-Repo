package com.idlix;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/idlix/SearchApiResponse;", "", "results", "", "Lcom/idlix/SearchApiResult;", "total", "", "<init>", "(Ljava/util/List;J)V", "getResults", "()Ljava/util/List;", "getTotal", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SearchApiResponse {

    @NotNull
    private final List<SearchApiResult> results;
    private final long total;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchApiResponse copy$default(SearchApiResponse searchApiResponse, List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = searchApiResponse.results;
        }
        if ((i & 2) != 0) {
            j = searchApiResponse.total;
        }
        return searchApiResponse.copy(list, j);
    }

    @NotNull
    public final List<SearchApiResult> component1() {
        return this.results;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTotal() {
        return this.total;
    }

    @NotNull
    public final SearchApiResponse copy(@NotNull List<SearchApiResult> results, long total) {
        return new SearchApiResponse(results, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchApiResponse)) {
            return false;
        }
        SearchApiResponse searchApiResponse = (SearchApiResponse) other;
        return Intrinsics.areEqual(this.results, searchApiResponse.results) && this.total == searchApiResponse.total;
    }

    public int hashCode() {
        return (this.results.hashCode() * 31) + SearchApiResponse$$ExternalSyntheticBackport0.m3m(this.total);
    }

    @NotNull
    public String toString() {
        return "SearchApiResponse(results=" + this.results + ", total=" + this.total + ')';
    }

    public SearchApiResponse(@NotNull List<SearchApiResult> list, long total) {
        this.results = list;
        this.total = total;
    }

    @NotNull
    public final List<SearchApiResult> getResults() {
        return this.results;
    }

    public final long getTotal() {
        return this.total;
    }
}
