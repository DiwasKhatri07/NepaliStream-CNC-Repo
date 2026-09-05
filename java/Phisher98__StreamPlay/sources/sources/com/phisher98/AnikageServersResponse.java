package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/AnikageServersResponse;", "", "servers", "", "Lcom/phisher98/AnikageServer;", "<init>", "(Ljava/util/List;)V", "getServers", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnikageServersResponse {

    @Nullable
    private final List<AnikageServer> servers;

    /* JADX WARN: Illegal instructions before constructor call */
    public AnikageServersResponse() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnikageServersResponse copy$default(AnikageServersResponse anikageServersResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = anikageServersResponse.servers;
        }
        return anikageServersResponse.copy(list);
    }

    @Nullable
    public final List<AnikageServer> component1() {
        return this.servers;
    }

    @NotNull
    public final AnikageServersResponse copy(@Nullable List<AnikageServer> servers) {
        return new AnikageServersResponse(servers);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnikageServersResponse) && Intrinsics.areEqual(this.servers, ((AnikageServersResponse) other).servers);
    }

    public int hashCode() {
        if (this.servers == null) {
            return 0;
        }
        return this.servers.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnikageServersResponse(servers=" + this.servers + ')';
    }

    public AnikageServersResponse(@Nullable List<AnikageServer> list) {
        this.servers = list;
    }

    public /* synthetic */ AnikageServersResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    @Nullable
    public final List<AnikageServer> getServers() {
        return this.servers;
    }
}
