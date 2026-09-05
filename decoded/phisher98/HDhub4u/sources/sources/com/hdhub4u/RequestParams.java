package com.hdhub4u;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/HDhub4u/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J[\u0010\u0019\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/hdhub4u/RequestParams;", "", "collectionName", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "collection_name", "firstQ", "first_q", "perPage", "", "per_page", "q", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getCollectionName", "()Ljava/lang/String;", "getFirstQ", "getPerPage", "()J", "getQ", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class RequestParams {

    @NotNull
    private final String collectionName;

    @NotNull
    private final String firstQ;
    private final long perPage;

    @NotNull
    private final String q;

    public static /* synthetic */ RequestParams copy$default(RequestParams requestParams, String str, String str2, long j, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestParams.collectionName;
        }
        if ((i & 2) != 0) {
            str2 = requestParams.firstQ;
        }
        if ((i & 4) != 0) {
            j = requestParams.perPage;
        }
        if ((i & 8) != 0) {
            str3 = requestParams.q;
        }
        String str4 = str3;
        return requestParams.copy(str, str2, j, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCollectionName() {
        return this.collectionName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstQ() {
        return this.firstQ;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getPerPage() {
        return this.perPage;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getQ() {
        return this.q;
    }

    @NotNull
    public final RequestParams copy(@JsonProperty("collection_name") @NotNull String collectionName, @JsonProperty("first_q") @NotNull String firstQ, @JsonProperty("per_page") long perPage, @NotNull String q) {
        return new RequestParams(collectionName, firstQ, perPage, q);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestParams)) {
            return false;
        }
        RequestParams requestParams = (RequestParams) other;
        return Intrinsics.areEqual(this.collectionName, requestParams.collectionName) && Intrinsics.areEqual(this.firstQ, requestParams.firstQ) && this.perPage == requestParams.perPage && Intrinsics.areEqual(this.q, requestParams.q);
    }

    public int hashCode() {
        return (((((this.collectionName.hashCode() * 31) + this.firstQ.hashCode()) * 31) + RequestParams$$ExternalSyntheticBackport0.m2m(this.perPage)) * 31) + this.q.hashCode();
    }

    @NotNull
    public String toString() {
        return "RequestParams(collectionName=" + this.collectionName + ", firstQ=" + this.firstQ + ", perPage=" + this.perPage + ", q=" + this.q + ')';
    }

    public RequestParams(@JsonProperty("collection_name") @NotNull String collectionName, @JsonProperty("first_q") @NotNull String firstQ, @JsonProperty("per_page") long perPage, @NotNull String q) {
        this.collectionName = collectionName;
        this.firstQ = firstQ;
        this.perPage = perPage;
        this.q = q;
    }

    @NotNull
    public final String getCollectionName() {
        return this.collectionName;
    }

    @NotNull
    public final String getFirstQ() {
        return this.firstQ;
    }

    public final long getPerPage() {
        return this.perPage;
    }

    @NotNull
    public final String getQ() {
        return this.q;
    }
}
