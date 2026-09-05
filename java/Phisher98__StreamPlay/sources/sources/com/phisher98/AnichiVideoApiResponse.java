package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u001c\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/phisher98/AnichiVideoApiResponse;", "", "links", "", "Lcom/phisher98/AnichiLinks;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getLinks", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiVideoApiResponse {

    @NotNull
    private final List<AnichiLinks> links;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnichiVideoApiResponse copy$default(AnichiVideoApiResponse anichiVideoApiResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = anichiVideoApiResponse.links;
        }
        return anichiVideoApiResponse.copy(list);
    }

    @NotNull
    public final List<AnichiLinks> component1() {
        return this.links;
    }

    @NotNull
    public final AnichiVideoApiResponse copy(@JsonProperty("links") @NotNull List<AnichiLinks> links) {
        return new AnichiVideoApiResponse(links);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnichiVideoApiResponse) && Intrinsics.areEqual(this.links, ((AnichiVideoApiResponse) other).links);
    }

    public int hashCode() {
        return this.links.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnichiVideoApiResponse(links=" + this.links + ')';
    }

    public AnichiVideoApiResponse(@JsonProperty("links") @NotNull List<AnichiLinks> list) {
        this.links = list;
    }

    @NotNull
    public final List<AnichiLinks> getLinks() {
        return this.links;
    }
}
