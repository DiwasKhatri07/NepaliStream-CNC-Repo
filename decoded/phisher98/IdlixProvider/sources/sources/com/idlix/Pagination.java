package com.idlix;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/idlix/Pagination;", "", "page", "", "limit", "total", "totalPages", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLimit", "getTotal", "getTotalPages", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/idlix/Pagination;", "equals", "", "other", "hashCode", "toString", "", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Pagination {

    @Nullable
    private final Integer limit;

    @Nullable
    private final Integer page;

    @Nullable
    private final Integer total;

    @Nullable
    private final Integer totalPages;

    public Pagination() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Pagination copy$default(Pagination pagination, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = pagination.page;
        }
        if ((i & 2) != 0) {
            num2 = pagination.limit;
        }
        if ((i & 4) != 0) {
            num3 = pagination.total;
        }
        if ((i & 8) != 0) {
            num4 = pagination.totalPages;
        }
        return pagination.copy(num, num2, num3, num4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getPage() {
        return this.page;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getLimit() {
        return this.limit;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getTotal() {
        return this.total;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getTotalPages() {
        return this.totalPages;
    }

    @NotNull
    public final Pagination copy(@Nullable Integer page, @Nullable Integer limit, @Nullable Integer total, @Nullable Integer totalPages) {
        return new Pagination(page, limit, total, totalPages);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Pagination)) {
            return false;
        }
        Pagination pagination = (Pagination) other;
        return Intrinsics.areEqual(this.page, pagination.page) && Intrinsics.areEqual(this.limit, pagination.limit) && Intrinsics.areEqual(this.total, pagination.total) && Intrinsics.areEqual(this.totalPages, pagination.totalPages);
    }

    public int hashCode() {
        return ((((((this.page == null ? 0 : this.page.hashCode()) * 31) + (this.limit == null ? 0 : this.limit.hashCode())) * 31) + (this.total == null ? 0 : this.total.hashCode())) * 31) + (this.totalPages != null ? this.totalPages.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Pagination(page=" + this.page + ", limit=" + this.limit + ", total=" + this.total + ", totalPages=" + this.totalPages + ')';
    }

    public Pagination(@Nullable Integer page, @Nullable Integer limit, @Nullable Integer total, @Nullable Integer totalPages) {
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.totalPages = totalPages;
    }

    public /* synthetic */ Pagination(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }

    @Nullable
    public final Integer getPage() {
        return this.page;
    }

    @Nullable
    public final Integer getLimit() {
        return this.limit;
    }

    @Nullable
    public final Integer getTotal() {
        return this.total;
    }

    @Nullable
    public final Integer getTotalPages() {
        return this.totalPages;
    }
}
