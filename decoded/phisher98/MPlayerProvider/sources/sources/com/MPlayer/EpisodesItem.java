package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bz\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bç\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020#\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0018\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020\f\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010.\u001a\u00020\u000e:\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\b\u00102\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00103\u001a\u00020\u000e\u0012\u0006\u00104\u001a\u00020\f\u0012\u0006\u00105\u001a\u00020\f\u0012\b\u00106\u001a\u0004\u0018\u00010\u0001\u0012\b\u00107\u001a\u0004\u0018\u00010\u0001\u0012\b\u00108\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u00109\u001a\u00020\f\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0001\u0012\u0016\b\u0001\u0010=\u001a\u00020\u000e:\f\b/\u0012\b\b0\u0012\u0004\b\b(>¢\u0006\u0004\b?\u0010@J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0003HÆ\u0003J\t\u0010z\u001a\u00020\u0007HÆ\u0003J\t\u0010{\u001a\u00020\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010~\u001a\u00020\fHÆ\u0003J\t\u0010\u007f\u001a\u00020\u000eHÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\fHÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\u0010\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\fHÆ\u0003J\u0010\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\u0010\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018HÆ\u0003J\u0010\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020#HÆ\u0003J\u0010\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020%0\u0018HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020+HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\fHÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\fHÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u000eHÆ\u0003JÄ\u0004\u0010¦\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u001b\u001a\u00020\f2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00182\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\f2\b\b\u0002\u0010-\u001a\u00020\u00032\u0016\b\u0003\u0010.\u001a\u00020\u000e:\f\b/\u0012\b\b0\u0012\u0004\b\b(12\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\f2\b\b\u0002\u00105\u001a\u00020\f2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u00109\u001a\u00020\f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00012\u0016\b\u0003\u0010=\u001a\u00020\u000e:\f\b/\u0012\b\b0\u0012\u0004\b\b(>HÆ\u0001J\u0016\u0010§\u0001\u001a\u00020\u000e2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\f\u0010©\u0001\u001a\u00030ª\u0001HÖ\u0081\u0004J\u000b\u0010«\u0001\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010BR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010BR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010BR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010IR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bO\u0010IR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bP\u0010IR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010IR\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bR\u0010LR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010NR\u0011\u0010\u0014\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bT\u0010LR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bU\u0010IR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010BR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\b\n\u0000\u001a\u0004\bY\u0010XR\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010LR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\b[\u0010XR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010XR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\b]\u0010XR\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010BR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u0010BR\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0018¢\u0006\b\n\u0000\u001a\u0004\bb\u0010XR\u0013\u0010&\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bc\u0010IR\u0013\u0010'\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bd\u0010IR\u0013\u0010(\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\be\u0010IR\u0013\u0010)\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bf\u0010IR\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0011\u0010,\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bi\u0010LR\u0011\u0010-\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010BR\u0011\u0010.\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bk\u0010NR\u0013\u00102\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010BR\u0011\u00103\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010NR\u0011\u00104\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bm\u0010LR\u0011\u00105\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bn\u0010LR\u0013\u00106\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bo\u0010IR\u0013\u00107\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bp\u0010IR\u0013\u00108\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bq\u0010IR\u0011\u00109\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\br\u0010LR\u0013\u0010:\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bs\u0010IR\u0013\u0010;\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bt\u0010IR\u0013\u0010<\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bu\u0010IR\u0011\u0010=\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bv\u0010N¨\u0006¬\u0001"}, d2 = {"Lcom/MPlayer/EpisodesItem;", "", "description", "", "title", "releaseDate", "stream", "Lcom/MPlayer/EpisodesStream;", "type", "tvodPackImageInfo", "tvodDetail", "watchAt", "", "lastWatched", "", "lastWatchedEpisodeId", "subtitleLanguageCode", "audioTrackLanguageCode", "statusCode", "lastTvShowEpisode", "rating", "descriptor", "id", "languages", "", "languagesDetails", "Lcom/MPlayer/EpisodesLanguagesDetail;", "duration", "genres", "genresDetails", "Lcom/MPlayer/GenresDetail;", "secondaryGenres", "publishTime", "shareUrl", "image", "Lcom/MPlayer/EpisodesImage;", "imageInfo", "Lcom/MPlayer/EpisodesImageInfo;", "titleContentImageInfo", "trailerPreview", "trailer", "firstVideo", "container", "Lcom/MPlayer/Container;", "sequence", "subType", "canPreviewGifvideo", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "canPreviewGIFVideo", "webUrl", "isOptimizedDescription", "childCount", "videoCount", "detailKey", "inlineData", "statistics", "viewCount", "overlayImages", "tabs", "goldBadgeImageInfo", "existInCw", "existInCW", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/MPlayer/EpisodesStream;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;JZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JZJLjava/lang/Object;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/MPlayer/EpisodesImage;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/MPlayer/Container;JLjava/lang/String;ZLjava/lang/String;ZJJLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)V", "getDescription", "()Ljava/lang/String;", "getTitle", "getReleaseDate", "getStream", "()Lcom/MPlayer/EpisodesStream;", "getType", "getTvodPackImageInfo", "()Ljava/lang/Object;", "getTvodDetail", "getWatchAt", "()J", "getLastWatched", "()Z", "getLastWatchedEpisodeId", "getSubtitleLanguageCode", "getAudioTrackLanguageCode", "getStatusCode", "getLastTvShowEpisode", "getRating", "getDescriptor", "getId", "getLanguages", "()Ljava/util/List;", "getLanguagesDetails", "getDuration", "getGenres", "getGenresDetails", "getSecondaryGenres", "getPublishTime", "getShareUrl", "getImage", "()Lcom/MPlayer/EpisodesImage;", "getImageInfo", "getTitleContentImageInfo", "getTrailerPreview", "getTrailer", "getFirstVideo", "getContainer", "()Lcom/MPlayer/Container;", "getSequence", "getSubType", "getCanPreviewGifvideo", "getWebUrl", "getChildCount", "getVideoCount", "getDetailKey", "getInlineData", "getStatistics", "getViewCount", "getOverlayImages", "getTabs", "getGoldBadgeImageInfo", "getExistInCw", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "copy", "equals", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodesItem {

    @Nullable
    private final Object audioTrackLanguageCode;
    private final boolean canPreviewGifvideo;
    private final long childCount;

    @NotNull
    private final Container container;

    @NotNull
    private final String description;

    @Nullable
    private final Object descriptor;

    @Nullable
    private final Object detailKey;
    private final long duration;
    private final boolean existInCw;

    @Nullable
    private final Object firstVideo;

    @NotNull
    private final List<String> genres;

    @NotNull
    private final List<GenresDetail> genresDetails;

    @Nullable
    private final Object goldBadgeImageInfo;

    @NotNull
    private final String id;

    @NotNull
    private final EpisodesImage image;

    @NotNull
    private final List<EpisodesImageInfo> imageInfo;

    @Nullable
    private final Object inlineData;
    private final boolean isOptimizedDescription;

    @NotNull
    private final List<String> languages;

    @NotNull
    private final List<EpisodesLanguagesDetail> languagesDetails;
    private final boolean lastTvShowEpisode;
    private final boolean lastWatched;

    @Nullable
    private final Object lastWatchedEpisodeId;

    @Nullable
    private final Object overlayImages;

    @NotNull
    private final String publishTime;
    private final long rating;

    @NotNull
    private final String releaseDate;

    @NotNull
    private final List<String> secondaryGenres;
    private final long sequence;

    @NotNull
    private final String shareUrl;

    @Nullable
    private final Object statistics;
    private final long statusCode;

    @NotNull
    private final EpisodesStream stream;

    @NotNull
    private final String subType;

    @Nullable
    private final Object subtitleLanguageCode;

    @Nullable
    private final Object tabs;

    @Nullable
    private final String title;

    @Nullable
    private final Object titleContentImageInfo;

    @Nullable
    private final Object trailer;

    @Nullable
    private final Object trailerPreview;

    @Nullable
    private final Object tvodDetail;

    @Nullable
    private final Object tvodPackImageInfo;

    @NotNull
    private final String type;
    private final long videoCount;
    private final long viewCount;
    private final long watchAt;

    @Nullable
    private final String webUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EpisodesItem copy$default(EpisodesItem episodesItem, String str, String str2, String str3, EpisodesStream episodesStream, String str4, Object obj, Object obj2, long j, boolean z, Object obj3, Object obj4, Object obj5, long j2, boolean z2, long j3, Object obj6, String str5, List list, List list2, long j4, List list3, List list4, List list5, String str6, String str7, EpisodesImage episodesImage, List list6, Object obj7, Object obj8, Object obj9, Object obj10, Container container, long j5, String str8, boolean z3, String str9, boolean z4, long j6, long j7, Object obj11, Object obj12, Object obj13, long j8, Object obj14, Object obj15, Object obj16, boolean z5, int i, int i2, Object obj17) {
        String str10 = (i & 1) != 0 ? episodesItem.description : str;
        String str11 = (i & 2) != 0 ? episodesItem.title : str2;
        String str12 = (i & 4) != 0 ? episodesItem.releaseDate : str3;
        EpisodesStream episodesStream2 = (i & 8) != 0 ? episodesItem.stream : episodesStream;
        String str13 = (i & 16) != 0 ? episodesItem.type : str4;
        Object obj18 = (i & 32) != 0 ? episodesItem.tvodPackImageInfo : obj;
        Object obj19 = (i & 64) != 0 ? episodesItem.tvodDetail : obj2;
        long j9 = (i & 128) != 0 ? episodesItem.watchAt : j;
        boolean z6 = (i & 256) != 0 ? episodesItem.lastWatched : z;
        Object obj20 = (i & 512) != 0 ? episodesItem.lastWatchedEpisodeId : obj3;
        Object obj21 = (i & 1024) != 0 ? episodesItem.subtitleLanguageCode : obj4;
        Object obj22 = (i & 2048) != 0 ? episodesItem.audioTrackLanguageCode : obj5;
        String str14 = str10;
        String str15 = str11;
        long j10 = (i & 4096) != 0 ? episodesItem.statusCode : j2;
        boolean z7 = (i & 8192) != 0 ? episodesItem.lastTvShowEpisode : z2;
        long j11 = (i & 16384) != 0 ? episodesItem.rating : j3;
        Object obj23 = (i & 32768) != 0 ? episodesItem.descriptor : obj6;
        String str16 = (i & 65536) != 0 ? episodesItem.id : str5;
        List list7 = (i & 131072) != 0 ? episodesItem.languages : list;
        List list8 = (i & 262144) != 0 ? episodesItem.languagesDetails : list2;
        long j12 = j11;
        long j13 = (i & 524288) != 0 ? episodesItem.duration : j4;
        List list9 = list8;
        List list10 = (i & 1048576) != 0 ? episodesItem.genres : list3;
        List list11 = (i & 2097152) != 0 ? episodesItem.genresDetails : list4;
        List list12 = (i & 4194304) != 0 ? episodesItem.secondaryGenres : list5;
        String str17 = (i & 8388608) != 0 ? episodesItem.publishTime : str6;
        String str18 = (i & 16777216) != 0 ? episodesItem.shareUrl : str7;
        EpisodesImage episodesImage2 = (i & 33554432) != 0 ? episodesItem.image : episodesImage;
        List list13 = (i & 67108864) != 0 ? episodesItem.imageInfo : list6;
        Object obj24 = (i & 134217728) != 0 ? episodesItem.titleContentImageInfo : obj7;
        Object obj25 = (i & 268435456) != 0 ? episodesItem.trailerPreview : obj8;
        Object obj26 = (i & 536870912) != 0 ? episodesItem.trailer : obj9;
        Object obj27 = (i & 1073741824) != 0 ? episodesItem.firstVideo : obj10;
        Container container2 = (i & Integer.MIN_VALUE) != 0 ? episodesItem.container : container;
        long j14 = (i2 & 1) != 0 ? episodesItem.sequence : j5;
        Container container3 = container2;
        String str19 = (i2 & 2) != 0 ? episodesItem.subType : str8;
        boolean z8 = (i2 & 4) != 0 ? episodesItem.canPreviewGifvideo : z3;
        String str20 = (i2 & 8) != 0 ? episodesItem.webUrl : str9;
        boolean z9 = (i2 & 16) != 0 ? episodesItem.isOptimizedDescription : z4;
        long j15 = j14;
        long j16 = (i2 & 32) != 0 ? episodesItem.childCount : j6;
        long j17 = (i2 & 64) != 0 ? episodesItem.videoCount : j7;
        return episodesItem.copy(str14, str15, str12, episodesStream2, str13, obj18, obj19, j9, z6, obj20, obj21, obj22, j10, z7, j12, obj23, str16, list7, list9, j13, list10, list11, list12, str17, str18, episodesImage2, list13, obj24, obj25, obj26, obj27, container3, j15, str19, z8, str20, z9, j16, j17, (i2 & 128) != 0 ? episodesItem.detailKey : obj11, (i2 & 256) != 0 ? episodesItem.inlineData : obj12, (i2 & 512) != 0 ? episodesItem.statistics : obj13, (i2 & 1024) != 0 ? episodesItem.viewCount : j8, (i2 & 2048) != 0 ? episodesItem.overlayImages : obj14, (i2 & 4096) != 0 ? episodesItem.tabs : obj15, (i2 & 8192) != 0 ? episodesItem.goldBadgeImageInfo : obj16, (i2 & 16384) != 0 ? episodesItem.existInCw : z5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Object getLastWatchedEpisodeId() {
        return this.lastWatchedEpisodeId;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Object getSubtitleLanguageCode() {
        return this.subtitleLanguageCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Object getAudioTrackLanguageCode() {
        return this.audioTrackLanguageCode;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getStatusCode() {
        return this.statusCode;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getLastTvShowEpisode() {
        return this.lastTvShowEpisode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getRating() {
        return this.rating;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Object getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<String> component18() {
        return this.languages;
    }

    @NotNull
    public final List<EpisodesLanguagesDetail> component19() {
        return this.languagesDetails;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final List<String> component21() {
        return this.genres;
    }

    @NotNull
    public final List<GenresDetail> component22() {
        return this.genresDetails;
    }

    @NotNull
    public final List<String> component23() {
        return this.secondaryGenres;
    }

    @NotNull
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getPublishTime() {
        return this.publishTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component26, reason: from getter */
    public final EpisodesImage getImage() {
        return this.image;
    }

    @NotNull
    public final List<EpisodesImageInfo> component27() {
        return this.imageInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component28, reason: from getter */
    public final Object getTitleContentImageInfo() {
        return this.titleContentImageInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Object getTrailerPreview() {
        return this.trailerPreview;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Object getTrailer() {
        return this.trailer;
    }

    @Nullable
    /* JADX INFO: renamed from: component31, reason: from getter */
    public final Object getFirstVideo() {
        return this.firstVideo;
    }

    @NotNull
    /* JADX INFO: renamed from: component32, reason: from getter */
    public final Container getContainer() {
        return this.container;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final long getSequence() {
        return this.sequence;
    }

    @NotNull
    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getSubType() {
        return this.subType;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final boolean getCanPreviewGifvideo() {
        return this.canPreviewGifvideo;
    }

    @Nullable
    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getWebUrl() {
        return this.webUrl;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final boolean getIsOptimizedDescription() {
        return this.isOptimizedDescription;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final long getChildCount() {
        return this.childCount;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final long getVideoCount() {
        return this.videoCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final EpisodesStream getStream() {
        return this.stream;
    }

    @Nullable
    /* JADX INFO: renamed from: component40, reason: from getter */
    public final Object getDetailKey() {
        return this.detailKey;
    }

    @Nullable
    /* JADX INFO: renamed from: component41, reason: from getter */
    public final Object getInlineData() {
        return this.inlineData;
    }

    @Nullable
    /* JADX INFO: renamed from: component42, reason: from getter */
    public final Object getStatistics() {
        return this.statistics;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final long getViewCount() {
        return this.viewCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component44, reason: from getter */
    public final Object getOverlayImages() {
        return this.overlayImages;
    }

    @Nullable
    /* JADX INFO: renamed from: component45, reason: from getter */
    public final Object getTabs() {
        return this.tabs;
    }

    @Nullable
    /* JADX INFO: renamed from: component46, reason: from getter */
    public final Object getGoldBadgeImageInfo() {
        return this.goldBadgeImageInfo;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final boolean getExistInCw() {
        return this.existInCw;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getTvodPackImageInfo() {
        return this.tvodPackImageInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getTvodDetail() {
        return this.tvodDetail;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getWatchAt() {
        return this.watchAt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getLastWatched() {
        return this.lastWatched;
    }

    @NotNull
    public final EpisodesItem copy(@NotNull String description, @Nullable String title, @NotNull String releaseDate, @NotNull EpisodesStream stream, @NotNull String type, @Nullable Object tvodPackImageInfo, @Nullable Object tvodDetail, long watchAt, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @Nullable Object subtitleLanguageCode, @Nullable Object audioTrackLanguageCode, long statusCode, boolean lastTvShowEpisode, long rating, @Nullable Object descriptor, @NotNull String id, @NotNull List<String> languages, @NotNull List<EpisodesLanguagesDetail> languagesDetails, long duration, @NotNull List<String> genres, @NotNull List<GenresDetail> genresDetails, @NotNull List<String> secondaryGenres, @NotNull String publishTime, @NotNull String shareUrl, @NotNull EpisodesImage image, @NotNull List<EpisodesImageInfo> imageInfo, @Nullable Object titleContentImageInfo, @Nullable Object trailerPreview, @Nullable Object trailer, @Nullable Object firstVideo, @NotNull Container container, long sequence, @NotNull String subType, @JsonProperty("canPreviewGIFVideo") boolean canPreviewGifvideo, @Nullable String webUrl, boolean isOptimizedDescription, long childCount, long videoCount, @Nullable Object detailKey, @Nullable Object inlineData, @Nullable Object statistics, long viewCount, @Nullable Object overlayImages, @Nullable Object tabs, @Nullable Object goldBadgeImageInfo, @JsonProperty("existInCW") boolean existInCw) {
        return new EpisodesItem(description, title, releaseDate, stream, type, tvodPackImageInfo, tvodDetail, watchAt, lastWatched, lastWatchedEpisodeId, subtitleLanguageCode, audioTrackLanguageCode, statusCode, lastTvShowEpisode, rating, descriptor, id, languages, languagesDetails, duration, genres, genresDetails, secondaryGenres, publishTime, shareUrl, image, imageInfo, titleContentImageInfo, trailerPreview, trailer, firstVideo, container, sequence, subType, canPreviewGifvideo, webUrl, isOptimizedDescription, childCount, videoCount, detailKey, inlineData, statistics, viewCount, overlayImages, tabs, goldBadgeImageInfo, existInCw);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodesItem)) {
            return false;
        }
        EpisodesItem episodesItem = (EpisodesItem) other;
        return Intrinsics.areEqual(this.description, episodesItem.description) && Intrinsics.areEqual(this.title, episodesItem.title) && Intrinsics.areEqual(this.releaseDate, episodesItem.releaseDate) && Intrinsics.areEqual(this.stream, episodesItem.stream) && Intrinsics.areEqual(this.type, episodesItem.type) && Intrinsics.areEqual(this.tvodPackImageInfo, episodesItem.tvodPackImageInfo) && Intrinsics.areEqual(this.tvodDetail, episodesItem.tvodDetail) && this.watchAt == episodesItem.watchAt && this.lastWatched == episodesItem.lastWatched && Intrinsics.areEqual(this.lastWatchedEpisodeId, episodesItem.lastWatchedEpisodeId) && Intrinsics.areEqual(this.subtitleLanguageCode, episodesItem.subtitleLanguageCode) && Intrinsics.areEqual(this.audioTrackLanguageCode, episodesItem.audioTrackLanguageCode) && this.statusCode == episodesItem.statusCode && this.lastTvShowEpisode == episodesItem.lastTvShowEpisode && this.rating == episodesItem.rating && Intrinsics.areEqual(this.descriptor, episodesItem.descriptor) && Intrinsics.areEqual(this.id, episodesItem.id) && Intrinsics.areEqual(this.languages, episodesItem.languages) && Intrinsics.areEqual(this.languagesDetails, episodesItem.languagesDetails) && this.duration == episodesItem.duration && Intrinsics.areEqual(this.genres, episodesItem.genres) && Intrinsics.areEqual(this.genresDetails, episodesItem.genresDetails) && Intrinsics.areEqual(this.secondaryGenres, episodesItem.secondaryGenres) && Intrinsics.areEqual(this.publishTime, episodesItem.publishTime) && Intrinsics.areEqual(this.shareUrl, episodesItem.shareUrl) && Intrinsics.areEqual(this.image, episodesItem.image) && Intrinsics.areEqual(this.imageInfo, episodesItem.imageInfo) && Intrinsics.areEqual(this.titleContentImageInfo, episodesItem.titleContentImageInfo) && Intrinsics.areEqual(this.trailerPreview, episodesItem.trailerPreview) && Intrinsics.areEqual(this.trailer, episodesItem.trailer) && Intrinsics.areEqual(this.firstVideo, episodesItem.firstVideo) && Intrinsics.areEqual(this.container, episodesItem.container) && this.sequence == episodesItem.sequence && Intrinsics.areEqual(this.subType, episodesItem.subType) && this.canPreviewGifvideo == episodesItem.canPreviewGifvideo && Intrinsics.areEqual(this.webUrl, episodesItem.webUrl) && this.isOptimizedDescription == episodesItem.isOptimizedDescription && this.childCount == episodesItem.childCount && this.videoCount == episodesItem.videoCount && Intrinsics.areEqual(this.detailKey, episodesItem.detailKey) && Intrinsics.areEqual(this.inlineData, episodesItem.inlineData) && Intrinsics.areEqual(this.statistics, episodesItem.statistics) && this.viewCount == episodesItem.viewCount && Intrinsics.areEqual(this.overlayImages, episodesItem.overlayImages) && Intrinsics.areEqual(this.tabs, episodesItem.tabs) && Intrinsics.areEqual(this.goldBadgeImageInfo, episodesItem.goldBadgeImageInfo) && this.existInCw == episodesItem.existInCw;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.description.hashCode() * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + this.releaseDate.hashCode()) * 31) + this.stream.hashCode()) * 31) + this.type.hashCode()) * 31) + (this.tvodPackImageInfo == null ? 0 : this.tvodPackImageInfo.hashCode())) * 31) + (this.tvodDetail == null ? 0 : this.tvodDetail.hashCode())) * 31) + EpisodesItem$$ExternalSyntheticBackport0.m5m(this.watchAt)) * 31) + EpisodesItem$$ExternalSyntheticBackport1.m6m(this.lastWatched)) * 31) + (this.lastWatchedEpisodeId == null ? 0 : this.lastWatchedEpisodeId.hashCode())) * 31) + (this.subtitleLanguageCode == null ? 0 : this.subtitleLanguageCode.hashCode())) * 31) + (this.audioTrackLanguageCode == null ? 0 : this.audioTrackLanguageCode.hashCode())) * 31) + EpisodesItem$$ExternalSyntheticBackport0.m5m(this.statusCode)) * 31) + EpisodesItem$$ExternalSyntheticBackport1.m6m(this.lastTvShowEpisode)) * 31) + EpisodesItem$$ExternalSyntheticBackport0.m5m(this.rating)) * 31) + (this.descriptor == null ? 0 : this.descriptor.hashCode())) * 31) + this.id.hashCode()) * 31) + this.languages.hashCode()) * 31) + this.languagesDetails.hashCode()) * 31) + EpisodesItem$$ExternalSyntheticBackport0.m5m(this.duration)) * 31) + this.genres.hashCode()) * 31) + this.genresDetails.hashCode()) * 31) + this.secondaryGenres.hashCode()) * 31) + this.publishTime.hashCode()) * 31) + this.shareUrl.hashCode()) * 31) + this.image.hashCode()) * 31) + this.imageInfo.hashCode()) * 31) + (this.titleContentImageInfo == null ? 0 : this.titleContentImageInfo.hashCode())) * 31) + (this.trailerPreview == null ? 0 : this.trailerPreview.hashCode())) * 31) + (this.trailer == null ? 0 : this.trailer.hashCode())) * 31) + (this.firstVideo == null ? 0 : this.firstVideo.hashCode())) * 31) + this.container.hashCode()) * 31) + EpisodesItem$$ExternalSyntheticBackport0.m5m(this.sequence)) * 31) + this.subType.hashCode()) * 31) + EpisodesItem$$ExternalSyntheticBackport1.m6m(this.canPreviewGifvideo)) * 31) + (this.webUrl == null ? 0 : this.webUrl.hashCode())) * 31) + EpisodesItem$$ExternalSyntheticBackport1.m6m(this.isOptimizedDescription)) * 31) + EpisodesItem$$ExternalSyntheticBackport0.m5m(this.childCount)) * 31) + EpisodesItem$$ExternalSyntheticBackport0.m5m(this.videoCount)) * 31) + (this.detailKey == null ? 0 : this.detailKey.hashCode())) * 31) + (this.inlineData == null ? 0 : this.inlineData.hashCode())) * 31) + (this.statistics == null ? 0 : this.statistics.hashCode())) * 31) + EpisodesItem$$ExternalSyntheticBackport0.m5m(this.viewCount)) * 31) + (this.overlayImages == null ? 0 : this.overlayImages.hashCode())) * 31) + (this.tabs == null ? 0 : this.tabs.hashCode())) * 31) + (this.goldBadgeImageInfo != null ? this.goldBadgeImageInfo.hashCode() : 0)) * 31) + EpisodesItem$$ExternalSyntheticBackport1.m6m(this.existInCw);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EpisodesItem(description=").append(this.description).append(", title=").append(this.title).append(", releaseDate=").append(this.releaseDate).append(", stream=").append(this.stream).append(", type=").append(this.type).append(", tvodPackImageInfo=").append(this.tvodPackImageInfo).append(", tvodDetail=").append(this.tvodDetail).append(", watchAt=").append(this.watchAt).append(", lastWatched=").append(this.lastWatched).append(", lastWatchedEpisodeId=").append(this.lastWatchedEpisodeId).append(", subtitleLanguageCode=").append(this.subtitleLanguageCode).append(", audioTrackLanguageCode=");
        sb.append(this.audioTrackLanguageCode).append(", statusCode=").append(this.statusCode).append(", lastTvShowEpisode=").append(this.lastTvShowEpisode).append(", rating=").append(this.rating).append(", descriptor=").append(this.descriptor).append(", id=").append(this.id).append(", languages=").append(this.languages).append(", languagesDetails=").append(this.languagesDetails).append(", duration=").append(this.duration).append(", genres=").append(this.genres).append(", genresDetails=").append(this.genresDetails).append(", secondaryGenres=").append(this.secondaryGenres);
        sb.append(", publishTime=").append(this.publishTime).append(", shareUrl=").append(this.shareUrl).append(", image=").append(this.image).append(", imageInfo=").append(this.imageInfo).append(", titleContentImageInfo=").append(this.titleContentImageInfo).append(", trailerPreview=").append(this.trailerPreview).append(", trailer=").append(this.trailer).append(", firstVideo=").append(this.firstVideo).append(", container=").append(this.container).append(", sequence=").append(this.sequence).append(", subType=").append(this.subType).append(", canPreviewGifvideo=");
        sb.append(this.canPreviewGifvideo).append(", webUrl=").append(this.webUrl).append(", isOptimizedDescription=").append(this.isOptimizedDescription).append(", childCount=").append(this.childCount).append(", videoCount=").append(this.videoCount).append(", detailKey=").append(this.detailKey).append(", inlineData=").append(this.inlineData).append(", statistics=").append(this.statistics).append(", viewCount=").append(this.viewCount).append(", overlayImages=").append(this.overlayImages).append(", tabs=").append(this.tabs).append(", goldBadgeImageInfo=").append(this.goldBadgeImageInfo);
        sb.append(", existInCw=").append(this.existInCw).append(')');
        return sb.toString();
    }

    public EpisodesItem(@NotNull String description, @Nullable String title, @NotNull String releaseDate, @NotNull EpisodesStream stream, @NotNull String type, @Nullable Object tvodPackImageInfo, @Nullable Object tvodDetail, long watchAt, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @Nullable Object subtitleLanguageCode, @Nullable Object audioTrackLanguageCode, long statusCode, boolean lastTvShowEpisode, long rating, @Nullable Object descriptor, @NotNull String id, @NotNull List<String> list, @NotNull List<EpisodesLanguagesDetail> list2, long duration, @NotNull List<String> list3, @NotNull List<GenresDetail> list4, @NotNull List<String> list5, @NotNull String publishTime, @NotNull String shareUrl, @NotNull EpisodesImage image, @NotNull List<EpisodesImageInfo> list6, @Nullable Object titleContentImageInfo, @Nullable Object trailerPreview, @Nullable Object trailer, @Nullable Object firstVideo, @NotNull Container container, long sequence, @NotNull String subType, @JsonProperty("canPreviewGIFVideo") boolean canPreviewGifvideo, @Nullable String webUrl, boolean isOptimizedDescription, long childCount, long videoCount, @Nullable Object detailKey, @Nullable Object inlineData, @Nullable Object statistics, long viewCount, @Nullable Object overlayImages, @Nullable Object tabs, @Nullable Object goldBadgeImageInfo, @JsonProperty("existInCW") boolean existInCw) {
        this.description = description;
        this.title = title;
        this.releaseDate = releaseDate;
        this.stream = stream;
        this.type = type;
        this.tvodPackImageInfo = tvodPackImageInfo;
        this.tvodDetail = tvodDetail;
        this.watchAt = watchAt;
        this.lastWatched = lastWatched;
        this.lastWatchedEpisodeId = lastWatchedEpisodeId;
        this.subtitleLanguageCode = subtitleLanguageCode;
        this.audioTrackLanguageCode = audioTrackLanguageCode;
        this.statusCode = statusCode;
        this.lastTvShowEpisode = lastTvShowEpisode;
        this.rating = rating;
        this.descriptor = descriptor;
        this.id = id;
        this.languages = list;
        this.languagesDetails = list2;
        this.duration = duration;
        this.genres = list3;
        this.genresDetails = list4;
        this.secondaryGenres = list5;
        this.publishTime = publishTime;
        this.shareUrl = shareUrl;
        this.image = image;
        this.imageInfo = list6;
        this.titleContentImageInfo = titleContentImageInfo;
        this.trailerPreview = trailerPreview;
        this.trailer = trailer;
        this.firstVideo = firstVideo;
        this.container = container;
        this.sequence = sequence;
        this.subType = subType;
        this.canPreviewGifvideo = canPreviewGifvideo;
        this.webUrl = webUrl;
        this.isOptimizedDescription = isOptimizedDescription;
        this.childCount = childCount;
        this.videoCount = videoCount;
        this.detailKey = detailKey;
        this.inlineData = inlineData;
        this.statistics = statistics;
        this.viewCount = viewCount;
        this.overlayImages = overlayImages;
        this.tabs = tabs;
        this.goldBadgeImageInfo = goldBadgeImageInfo;
        this.existInCw = existInCw;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @NotNull
    public final EpisodesStream getStream() {
        return this.stream;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Object getTvodPackImageInfo() {
        return this.tvodPackImageInfo;
    }

    @Nullable
    public final Object getTvodDetail() {
        return this.tvodDetail;
    }

    public final long getWatchAt() {
        return this.watchAt;
    }

    public final boolean getLastWatched() {
        return this.lastWatched;
    }

    @Nullable
    public final Object getLastWatchedEpisodeId() {
        return this.lastWatchedEpisodeId;
    }

    @Nullable
    public final Object getSubtitleLanguageCode() {
        return this.subtitleLanguageCode;
    }

    @Nullable
    public final Object getAudioTrackLanguageCode() {
        return this.audioTrackLanguageCode;
    }

    public final long getStatusCode() {
        return this.statusCode;
    }

    public final boolean getLastTvShowEpisode() {
        return this.lastTvShowEpisode;
    }

    public final long getRating() {
        return this.rating;
    }

    @Nullable
    public final Object getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<String> getLanguages() {
        return this.languages;
    }

    @NotNull
    public final List<EpisodesLanguagesDetail> getLanguagesDetails() {
        return this.languagesDetails;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final List<String> getGenres() {
        return this.genres;
    }

    @NotNull
    public final List<GenresDetail> getGenresDetails() {
        return this.genresDetails;
    }

    @NotNull
    public final List<String> getSecondaryGenres() {
        return this.secondaryGenres;
    }

    @NotNull
    public final String getPublishTime() {
        return this.publishTime;
    }

    @NotNull
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    public final EpisodesImage getImage() {
        return this.image;
    }

    @NotNull
    public final List<EpisodesImageInfo> getImageInfo() {
        return this.imageInfo;
    }

    @Nullable
    public final Object getTitleContentImageInfo() {
        return this.titleContentImageInfo;
    }

    @Nullable
    public final Object getTrailerPreview() {
        return this.trailerPreview;
    }

    @Nullable
    public final Object getTrailer() {
        return this.trailer;
    }

    @Nullable
    public final Object getFirstVideo() {
        return this.firstVideo;
    }

    @NotNull
    public final Container getContainer() {
        return this.container;
    }

    public final long getSequence() {
        return this.sequence;
    }

    @NotNull
    public final String getSubType() {
        return this.subType;
    }

    public final boolean getCanPreviewGifvideo() {
        return this.canPreviewGifvideo;
    }

    @Nullable
    public final String getWebUrl() {
        return this.webUrl;
    }

    public final boolean isOptimizedDescription() {
        return this.isOptimizedDescription;
    }

    public final long getChildCount() {
        return this.childCount;
    }

    public final long getVideoCount() {
        return this.videoCount;
    }

    @Nullable
    public final Object getDetailKey() {
        return this.detailKey;
    }

    @Nullable
    public final Object getInlineData() {
        return this.inlineData;
    }

    @Nullable
    public final Object getStatistics() {
        return this.statistics;
    }

    public final long getViewCount() {
        return this.viewCount;
    }

    @Nullable
    public final Object getOverlayImages() {
        return this.overlayImages;
    }

    @Nullable
    public final Object getTabs() {
        return this.tabs;
    }

    @Nullable
    public final Object getGoldBadgeImageInfo() {
        return this.goldBadgeImageInfo;
    }

    public final boolean getExistInCw() {
        return this.existInCw;
    }
}
