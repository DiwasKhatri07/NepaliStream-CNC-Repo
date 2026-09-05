package com.idlix;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/idlix/ApiResponse;", "", "data", "", "Lcom/idlix/ApiItem;", "pagination", "Lcom/idlix/Pagination;", "meta", "Lcom/idlix/Meta;", "<init>", "(Ljava/util/List;Lcom/idlix/Pagination;Lcom/idlix/Meta;)V", "getData", "()Ljava/util/List;", "getPagination", "()Lcom/idlix/Pagination;", "getMeta", "()Lcom/idlix/Meta;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ApiResponse {

    @NotNull
    private final List<ApiItem> data;

    @Nullable
    private final Meta meta;

    @Nullable
    private final Pagination pagination;

    public ApiResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiResponse copy$default(ApiResponse apiResponse, List list, Pagination pagination, Meta meta, int i, Object obj) {
        if ((i & 1) != 0) {
            list = apiResponse.data;
        }
        if ((i & 2) != 0) {
            pagination = apiResponse.pagination;
        }
        if ((i & 4) != 0) {
            meta = apiResponse.meta;
        }
        return apiResponse.copy(list, pagination, meta);
    }

    @NotNull
    public final List<ApiItem> component1() {
        return this.data;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Pagination getPagination() {
        return this.pagination;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Meta getMeta() {
        return this.meta;
    }

    @NotNull
    public final ApiResponse copy(@NotNull List<ApiItem> data, @Nullable Pagination pagination, @Nullable Meta meta) {
        return new ApiResponse(data, pagination, meta);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiResponse)) {
            return false;
        }
        ApiResponse apiResponse = (ApiResponse) other;
        return Intrinsics.areEqual(this.data, apiResponse.data) && Intrinsics.areEqual(this.pagination, apiResponse.pagination) && Intrinsics.areEqual(this.meta, apiResponse.meta);
    }

    public int hashCode() {
        return (((this.data.hashCode() * 31) + (this.pagination == null ? 0 : this.pagination.hashCode())) * 31) + (this.meta != null ? this.meta.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ApiResponse(data=" + this.data + ", pagination=" + this.pagination + ", meta=" + this.meta + ')';
    }

    public ApiResponse(@NotNull List<ApiItem> list, @Nullable Pagination pagination, @Nullable Meta meta) {
        this.data = list;
        this.pagination = pagination;
        this.meta = meta;
    }

    public /* synthetic */ ApiResponse(List list, Pagination pagination, Meta meta, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : pagination, (i & 4) != 0 ? null : meta);
    }

    @NotNull
    public final List<ApiItem> getData() {
        return this.data;
    }

    @Nullable
    public final Pagination getPagination() {
        return this.pagination;
    }

    @Nullable
    public final Meta getMeta() {
        return this.meta;
    }
}
