package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/phisher98/JikanResponse;", "", "data", "Lcom/phisher98/JikanData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/JikanData;)V", "getData", "()Lcom/phisher98/JikanData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class JikanResponse {

    @Nullable
    private final JikanData data;

    /* JADX WARN: Illegal instructions before constructor call */
    public JikanResponse() {
        JikanData jikanData = null;
        this(jikanData, 1, jikanData);
    }

    public static /* synthetic */ JikanResponse copy$default(JikanResponse jikanResponse, JikanData jikanData, int i, Object obj) {
        if ((i & 1) != 0) {
            jikanData = jikanResponse.data;
        }
        return jikanResponse.copy(jikanData);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JikanData getData() {
        return this.data;
    }

    @NotNull
    public final JikanResponse copy(@JsonProperty("data") @Nullable JikanData data) {
        return new JikanResponse(data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof JikanResponse) && Intrinsics.areEqual(this.data, ((JikanResponse) other).data);
    }

    public int hashCode() {
        if (this.data == null) {
            return 0;
        }
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "JikanResponse(data=" + this.data + ')';
    }

    public JikanResponse(@JsonProperty("data") @Nullable JikanData data) {
        this.data = data;
    }

    public /* synthetic */ JikanResponse(JikanData jikanData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jikanData);
    }

    @Nullable
    public final JikanData getData() {
        return this.data;
    }
}
